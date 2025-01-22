//За дадена низа од случајни броеви кои се внесуваат од стандарден влез, да се направи преместување на сите нули на почеток на низата. На стандарден излез да се испечати трансформираната низа.
//
//For example:
//Input
//12
//1 9 8 4 0 0 2 7 0 6 0 9
//
//Result
//Transformiranata niza e:
//0 0 0 0 1 9 8 4 2 7 6 9

import java.util.*;

class PushZero
{
    public static void main (String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();

        Integer n = scanner.nextInt();
        for(int i = 0; i < n; i++){
            arr.add(scanner.nextInt());
        }

        ArrayList<Integer> sortedArr = new ArrayList<>();
        arr.forEach(x -> {
            if(x == 0){
                sortedArr.add(0, 0);
            } else {
                sortedArr.add(x);
            }
        });

        System.out.println("Transformiranata niza e:");
        sortedArr.forEach(x -> {
            System.out.print(x + " ");
        });
    }
}
