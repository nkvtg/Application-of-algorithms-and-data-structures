//Дадени се N возови со време на пристигање и поаѓање. Да се најде минималниот број на платформи потребен за да се сместат тие возови.
//
//Влез: Првиот број од влезот е бројот на возови N, а потоа во следниот ред минутата на пристигнување и минутата на поаѓање на возот.
//Излез: Најмалиот потребен број на платформи за да се сместат сите возови


import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> arrival = new ArrayList<>();
        ArrayList<Integer> departure = new ArrayList<>();

        int n = scanner.nextInt();
        for(int i=0; i<n; i++){
            arrival.add(scanner.nextInt());
            departure.add(scanner.nextInt());
        }

        int maxPlatforms = 1;

        for(int i=0; i<n; i++){
            int platformsNeeded = 1;
            for(int j=i+1; j<n; j++){
                if((arrival.get(i)>=arrival.get(j) && arrival.get(i)<=departure.get(j)) ||
                   (arrival.get(j)>=arrival.get(i) && arrival.get(j)<=departure.get(i))){
                    platformsNeeded++;
                }
                maxPlatforms = Math.max(maxPlatforms, platformsNeeded);
            }
        }

        System.out.println(maxPlatforms);
    }
}
