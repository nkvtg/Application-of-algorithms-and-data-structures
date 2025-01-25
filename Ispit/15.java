//Дадени се Н цифри. Да се напише алгоритам кој ќе го даде најголемиот можен број составен од тие цифри.
//
//Влез: Првиот број од влезот е бројот на цифри N, а потоа во следниот ред се цифрите.
//Излез: Најголемиот број кој може да се состави од тие цифри


import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> arr = new ArrayList<>();

        int n = scanner.nextInt();
        for(int i=0; i<n; i++){
            arr.add(scanner.nextInt());
        }

        arr.sort(Comparator.reverseOrder());

        for(int i=0; i<arr.size(); i++){
            System.out.print(arr.get(i));
        }
    }
}
