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

        Collections.sort(arrival);
        Collections.sort(departure);

        int platformsNeeded = 0, maxPlatforms = 0;
        int i=0, j=0;

        while(i<n && j<n){
            if(arrival.get(i) <= departure.get(j)){
                platformsNeeded++;
                i++;
                maxPlatforms = Math.max(maxPlatforms, platformsNeeded);
            } else {
                platformsNeeded--;
                j++;
            }
        }

        System.out.println(maxPlatforms);
    }
}
