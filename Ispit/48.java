//Дадени се рутери означени со броеви од 0 до N-1 кои се поврзани во мрежа. Ако некој рутер R падне, мрежата може да се подели на групи на рутери што не се меѓусебно поврзани. Секој рутер од една група е поврзан со барем еден друг рутер од групата, а не е поврзан со рутери надвор од групата. Да се одреди колку вакви групи ќе настанат доколку рутерот R престане да работи.
//
//
//Влез: Во првиот ред е даден бројот на рутери N. Во следниот ред е даден бројот на врски помеѓу рутерите M, а во следните M редови се дадени рутерите кои ги поврзува секоја врска. Во последниот ред е даден рутерот R што престанал да работи.
//
//Излез:  Бројот на групи на рутери.

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>();
        ArrayList<Integer> vertices = new ArrayList<>();

        int n = scanner.nextInt();
        for(int i=0; i<n; i++){
            graph.addVertex(i);
            vertices.add(i);
        }

        int m = scanner.nextInt();
        for(int i=0; i<m; i++){
            graph.addEdge(scanner.nextInt(),scanner.nextInt());
        }

        int r = scanner.nextInt();
        graph.removeVertex(r);
        vertices.remove(r);

        int count = 0;
        Set<Integer> visited = new HashSet<>();

        for(Integer vertex : vertices){
            if (!visited.contains(vertex)) {
                graph.DFSUtil(vertex,visited);
                count++;
            }
        }

        System.out.println(count);
    }
}

class AdjacencyListGraph<T> {
    private Map<T, Set<T>> adjacencyList;

    public AdjacencyListGraph() {
        this.adjacencyList = new HashMap<>();
    }

    // Add a vertex to the graph
    public void addVertex(T vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            adjacencyList.put(vertex, new HashSet<>());
        }
    }

    // Remove a vertex from the graph
    public void removeVertex(T vertex) {
        // Remove the vertex from all adjacency lists
        for (Set<T> neighbors : adjacencyList.values()) {
            neighbors.remove(vertex);
        }
        // Remove the vertex's own entry in the adjacency list
        adjacencyList.remove(vertex);
    }

    // Add an edge to the graph
    public void addEdge(T source, T destination) {
        addVertex(source);
        addVertex(destination);

        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source); // for undirected graph
    }

    // Remove an edge from the graph
    public void removeEdge(T source, T destination) {
        if (adjacencyList.containsKey(source)) {
            adjacencyList.get(source).remove(destination);
        }
        if (adjacencyList.containsKey(destination)) {
            adjacencyList.get(destination).remove(source); // for undirected graph
        }
    }

    // Get all neighbors of a vertex
    public Set<T> getNeighbors(T vertex) {
        return adjacencyList.getOrDefault(vertex, new HashSet<>());
    }

    public void DFS(T startVertex) {
        Set<T> visited = new HashSet<>();
        DFSUtil(startVertex, visited);
    }

    public void DFSUtil(T vertex, Set<T> visited) {
        // Mark the current node as visited and print it
        visited.add(vertex);
//        System.out.print(vertex + " ");

        // Recur for all the vertices adjacent to this vertex
        for (T neighbor : getNeighbors(vertex)) {
            if (!visited.contains(neighbor)) {
                DFSUtil(neighbor, visited);
            }
        }
    }


    public void DFSNonRecursive(T startVertex) {
        Set<T> visited = new HashSet<>();
        Stack<T> stack = new Stack<>();

        stack.push(startVertex);
        while (!stack.isEmpty()) {
            T vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                System.out.print(vertex + " ");
                for (T neighbor : getNeighbors(vertex)) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }

    public void BFS(T startVertex) {
        Set<T> visited = new HashSet<>();
        Queue<T> queue = new LinkedList<>();

        visited.add(startVertex);
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            T vertex = queue.poll();
            System.out.print(vertex + " ");

            for (T neighbor : getNeighbors(vertex)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    public int shortestPath(T startVertex, T endVertex) {
        Set<T> visited = new HashSet<>();
        Queue<T> queue = new LinkedList<>();

        visited.add(startVertex);
        queue.add(startVertex);
        int elementsAtLevel;
        int level = 0;

        while (!queue.isEmpty()) {
            elementsAtLevel = queue.size();
            while (elementsAtLevel > 0) {
                T vertex = queue.poll();
                if (vertex.equals(endVertex))
                    return level;

                for (T neighbor : getNeighbors(vertex)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
                elementsAtLevel--;
            }
            level++;
        }
        return -1;
    }

    public void pathsOfLengthN(T startVertex, int goalLength) {
        Set<T> visited = new HashSet<>();
        ArrayList<T> startPath = new ArrayList<>();
        startPath.add(startVertex);
        pathsOfLengthNUtil(startVertex, goalLength, visited, startPath);
    }

    private void pathsOfLengthNUtil(T vertex, int goalLength, Set<T> visited, List<T> currentPath) {
        if (currentPath.size()==goalLength+1) {
            System.out.println(currentPath);
            return;
        }
        visited.add(vertex);
        for (T neighbor : getNeighbors(vertex)) {
            if (!visited.contains(neighbor)) {
                currentPath.add(neighbor);
                pathsOfLengthNUtil(neighbor, goalLength, visited, currentPath);
                currentPath.remove(neighbor);
            }
        }
        visited.remove(vertex);
    }


    public void findPath(T startVertex, T endVertex) {
        Set<T> visited = new HashSet<>();
        Stack<T> invertedPath = new Stack<>();
        visited.add(startVertex);
        invertedPath.push(startVertex);

        while(!invertedPath.isEmpty() && !invertedPath.peek().equals(endVertex)) {
            T currentVertex = invertedPath.peek();
            T tmp = currentVertex;

            for(T vertex : getNeighbors(currentVertex)) {
                tmp = vertex;
                if(!visited.contains(vertex)) {
                    break;
                }
            }

            if(!visited.contains(tmp)) {
                visited.add(tmp);
                invertedPath.push(tmp);
            }
            else {
                invertedPath.pop();
            }
        }

        Stack<T> path = new Stack<>();
        while(!invertedPath.isEmpty()) {
            path.push(invertedPath.pop());
        }
        while(!path.isEmpty()) {
            System.out.println(path.pop());
        }
    }

    @Override
    public String toString() {
        String ret = new String();
        for (Map.Entry<T, Set<T>> vertex : adjacencyList.entrySet())
            ret += vertex.getKey() + ": " + vertex.getValue() + "\n";
        return ret;
    }



}
