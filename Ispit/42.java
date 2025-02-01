//Дадена е двострано поврзана листа од цели броеви. Дополнително, дадени се и уште еден цел број M и еден природен број k. Треба да се најде првото појавување на M во листата и тој број да се помести k места на лево.
//
//Влез: Во првиот ред од влезот е даден бројот на елементи во листата - N, па во следните следниот ред самите елементи одделени со празно место. На крај, во последните два реда дадени се целиот број M и природниот број k.
//Излез: На излез треба да се испечати листата пред и после промената.

import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> arr = new ArrayList<>();

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
        }
        for(int i=0; i<n; i++){
            if(i<n-1){
                System.out.print(arr.get(i)+"<->");
            } else {
                System.out.print(arr.get(i));
            }
        }
        System.out.println();

        int m = scanner.nextInt();
        int k = scanner.nextInt();

        int foundIndex = -1;
        for(int i=0; i<n; i++){
            if(arr.get(i) == m){
                foundIndex=i;
                break;
            }
        }

        if(foundIndex==-1){
            System.out.println("Elementot ne postoi vo listata");
            for(int i=0; i<n; i++){
                if(i<n-1){
                    System.out.print(arr.get(i)+"<->");
                } else {
                    System.out.print(arr.get(i));
                }
            }
            return;
        }

        int foundElement = arr.get(foundIndex);
        arr.remove(foundIndex);

        if(foundIndex-k<0){
            arr.add(n-(k-foundIndex), foundElement);
        } else {
            arr.add(foundIndex-k, foundElement);
        }


        for(int i=0; i<n; i++){
            if(i<n-1){
                System.out.print(arr.get(i)+"<->");
            } else {
                System.out.print(arr.get(i));
            }
        }
    }
}
