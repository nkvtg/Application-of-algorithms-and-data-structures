//Дадена е сортирана низа од N броеви и број М кој го бараме во таа низа. Со помош на методата „раздели па владеј“ да се имплементира бинарно пребарување, да се најде бараниот број во таа низа и да се испечати неговата позиција. Доколку бројот не е во низата да е испечати "Ne postoi".
//
//Влез: Првиот број од влезот е големината на низата N и бараниот број М, а потоа во следниот ред се елементите на низата.
//Излез: Позицијата на која се наоѓа бараниот број, или "Ne postoi" доколку бројот не се наоѓа во низата.

import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0; i<n; i++){
            arr.add(scanner.nextInt());
        }

        int foundIndex = Collections.binarySearch(arr, m);
        if(foundIndex < 0){
            System.out.println("Ne postoi");
        } else {
            System.out.println(foundIndex);
        }
    }
}
