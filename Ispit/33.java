//Во следната задача треба да изградите неподредено (општо) дрво со N јазли, за кое ќе треба да одговорите на Q прашања од видот „колку лисја има поддрвото на избран јазол“.
//
//Секој јазол ќе има уникатен индекс од 1 до N. Коренот на дрвото секогаш ќе има индекс 1. Сите деца ќе имаат индекси поголеми од индексите на родителите.
//
//Влезот ќе содржи N+Q редови од видот
//
//    root 1 - Треба да го поставите коренот на дрвото да биде јазелот со индекс 1
//
//    add parent_index child_index - Треба да додадете дете јазел со индекс child_index на јазелот со индекс parent_index
//
//    ask node_index - Треба да одговорите колку листови има во поддрвото на јазелот со индекс node_index

import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        SLLTree<Integer> tree = new SLLTree<>();
        HashMap<Integer, SLLTree.SLLNode<Integer>> map = new HashMap<>();

        int n = scanner.nextInt();
        int q = scanner.nextInt();

        for(int i=0; i<n+q; i++){
            String command = scanner.next();
            if(command.equals("root")){
                int root = scanner.nextInt();
                tree.makeRoot(root);
                map.putIfAbsent(root,tree.root);
            } else if(command.equals("add")){
                int parent = scanner.nextInt();
                int child = scanner.nextInt();

                SLLTree.SLLNode<Integer> parentE = map.get(parent);
                SLLTree.SLLNode<Integer> childE = (SLLTree.SLLNode<Integer>) tree.addChild(parentE,child);
                map.putIfAbsent(child,childE);
            } else if(command.equals("ask")){
                int question = scanner.nextInt();
                SLLTree.SLLNode<Integer> node = map.get(question);
                System.out.println(countChildren(node));
            }
        }
    }

    public static int countChildren(SLLTree.SLLNode<Integer> node){
        if(node == null){
            return 0;
        }
        if(node.firstChild == null){
            return 1;
        }

        int num = 0;
        SLLTree.SLLNode<Integer> child = node.firstChild;
        while(child!=null){
            num += countChildren(child);
            child = child.sibling;
        }

        return num;
    }
}

class SLLTree<E> implements Tree<E> {

    // SLLNode is the implementation of the Node interface
    public static class SLLNode<P> implements Node<P> {

        // Holds the links to the needed nodes
        SLLNode<P> parent, sibling, firstChild;

        // Hold the data
        P element;

        public SLLNode(P o) {
            element = o;
            parent = sibling = firstChild = null;
        }

        public P getElement() {
            return element;
        }

        public void setElement(P o) {
            element = o;
        }

    }

    protected SLLNode<E> root;

    public SLLTree() {
        root = null;
    }

    public Node<E> root() {
        return root;
    }

    public Tree.Node<E> parent(Tree.Node<E> node) {
        return ((SLLNode<E>) node).parent;
    }

    public int childCount(Tree.Node<E> node) {
        SLLNode<E> tmp = ((SLLNode<E>) node).firstChild;
        int num = 0;
        while (tmp != null) {
            tmp = tmp.sibling;
            num++;
        }
        return num;
    }

    public void makeRoot(E elem) {
        root = new SLLNode<E>(elem);
    }

    public Node<E> addChild(Node<E> node, E elem) {
        SLLNode<E> tmp = new SLLNode<E>(elem);
        SLLNode<E> curr = (SLLNode<E>) node;
        tmp.sibling = curr.firstChild;
        curr.firstChild = tmp;
        tmp.parent = curr;
        return tmp;
    }

    public void remove(Tree.Node<E> node) {
        SLLNode<E> curr = (SLLNode<E>) node;
        if (curr.parent != null) {
            if (curr.parent.firstChild == curr) {
                // The node is the first child of its parent
                // Reconnect the parent to the next sibling
                curr.parent.firstChild = curr.sibling;
            } else {
                // The node is not the first child of its parent
                // Start from the first and search the node in the sibling list
                // and remove it
                SLLNode<E> tmp = curr.parent.firstChild;
                while (tmp.sibling != curr) {
                    tmp = tmp.sibling;
                }
                tmp.sibling = curr.sibling;
            }
        } else {
            root = null;
        }
    }

    class SLLTreeIterator implements Iterator<E> {

        SLLNode<E> start, current;

        public SLLTreeIterator(SLLNode<E> node) {
            start = node;
            current = node;
        }

        public boolean hasNext() {
            return (current != null);
        }

        public E next() throws NoSuchElementException {
            if (current != null) {
                SLLNode<E> tmp = current;
                current = current.sibling;
                return tmp.getElement();
            } else {
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            if (current != null) {
                current = current.sibling;
            }
        }
    }

    public Iterator<E> children(Tree.Node<E> node) {
        return new SLLTreeIterator(((SLLNode<E>) node).firstChild);
    }


    void printTreeRecursive(Node<E> node, int level) {
        if (node == null)
            return;
        int i;
        SLLNode<E> tmp;

        for (i = 0; i < level; i++)
            System.out.print("  ");
        System.out.println(node.getElement().toString());
        tmp = ((SLLNode<E>) node).firstChild;
        while (tmp != null) {
            printTreeRecursive(tmp, level + 1);
            tmp = tmp.sibling;
        }
    }

    public void printTree() {
        printTreeRecursive(root, 0);
    }

    public int countMaxChildren() {
        return countMaxChildrenRecursive(root);
    }

    int countMaxChildrenRecursive(SLLNode<E> node) {
        int t = childCount(node);
        SLLNode<E> tmp = node.firstChild;
        while (tmp != null) {
            t = Math.max(t, countMaxChildrenRecursive(tmp));
            tmp = tmp.sibling;
        }
        return t;
    }


    @Override
    public Iterable<Node<E>> childrenNodes(Node<E> node) {
        return new NodeIterable(((SLLNode<E>)node).firstChild);
    }

    public class NodeIterable implements Iterable<Node<E>>{

        Node<E> start;
        public NodeIterable(Node<E> start) {
            this.start = start;
        }

        @Override
        public Iterator<Node<E>> iterator() {
            return new NodeIterator(start);
        }
    }

    public class NodeIterator implements Iterator<Node<E>> {
        Node<E> current;

        public NodeIterator(Node<E> node) {
            current = node;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Node<E> next() {
            Node<E> rez = current;
            current = ((SLLNode<E>) current).sibling;
            return rez;
        }
    }
}

interface Tree<E> {
    // //////////Accessors ////////////

    public Tree.Node<E> root();

    public Tree.Node<E> parent(Tree.Node<E> node);

    public int childCount(Tree.Node<E> node);

    // //////////Transformers ////////////
    public void makeRoot(E elem);

    public Tree.Node<E> addChild(Tree.Node<E> node, E elem);

    public void remove(Tree.Node<E> node);

    // //////////Iterators ////////////
    public Iterator<E> children(Tree.Node<E> node);

    public Iterable<Tree.Node<E>> childrenNodes(Tree.Node<E> node);

    // //////Inner interface for tree nodes ////////
    public interface Node<E> {

        public E getElement();

        public void setElement(E elem);

    }
}
