//адени се N состаноци со време на почеток и крај. Да се најде минималниот број на сали за состаноци потребен за да се одржат сите состаноци.
//
//
//Влез: Првиот број од влезот е бројот на состаноци N, а потоа во следниот ред минутата на почнување и минутата на завршување на состанокот.
//Излез: Најмалиот потребен број на соби за состаноци за да можат да се одржат сите состаноци


import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> start = new ArrayList<>();
        ArrayList<Integer> end = new ArrayList<>();

        int n = scanner.nextInt();
        for(int i=0; i<n; i++){
            start.add(scanner.nextInt());
            end.add(scanner.nextInt());
        }

        Collections.sort(start);
        Collections.sort(end);

        int maxRooms = 1;
        for(int i=0; i<n; i++){
            int neededRooms = 1;
            for(int j=i+1; j<n; j++){
                if((start.get(i) >= start.get(j) && end.get(i) <= end.get(j)) ||
                (start.get(j) >= start.get(i) && start.get(j) <= end.get(i))){
                    neededRooms++;
                }
            }
            maxRooms = Math.max(maxRooms, neededRooms);
        }

        System.out.println(maxRooms);
    }
}
