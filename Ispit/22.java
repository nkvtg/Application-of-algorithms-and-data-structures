//Дадена е низа со N природни броеви. Треба да се сортира низата така што во првиот дел од низата ќе бидат подредени непарните броеви од неа во растечки редослед, а во вториот дел парните броеви во опаѓачки редослед. 
//
//Во првиот ред од влезот даден е бројот на елементи во низата N, а во вториот ред се дадени броевите. На излез треба да се испечати сортираната низа.
//
//Име на класата: OddEvenSort

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OddEvenSort {

    static void oddEvenSort(int a[], int n)
    {
        //Vasiot kod tuka
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(a[i] % 2 == 0){
                even.add(a[i]);
            } else {
                odd.add(a[i]);
            }
        }

        even.sort(Comparator.reverseOrder());
        odd.sort(Comparator.naturalOrder());

        odd.addAll(even);
        for(int i=0; i<n; i++){
            a[i] = odd.get(i);
        }
    }

    public static void main(String[] args) throws IOException{
        int i;
        BufferedReader stdin = new BufferedReader( new InputStreamReader(System.in));
        String s = stdin.readLine();
        int n = Integer.parseInt(s);

        s = stdin.readLine();
        String [] pom = s.split(" ");
        int [] a = new int[n];
        for(i=0;i<n;i++)
            a[i]=Integer.parseInt(pom[i]);
        oddEvenSort(a,n);
        for(i=0;i<n-1;i++)
            System.out.print(a[i]+" ");
        System.out.print(a[i]);
    }
}
