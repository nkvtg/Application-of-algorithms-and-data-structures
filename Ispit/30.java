//Даден ви е речник на зборови на кумановски дијалект и како тие се пишуваат на македонски јазик. Потоа даден ви е текст којшто е напишан на кумановски дијалект. Потребно е да ги замените сите појавувања на зборовите на кумановскиот дијалект кои се дадени во речникот со соодветни зборови на македонски јазик.
//
//Забелешка: Треба да се игнорираат интерпункциските знаци точка (.) , запирка (,), извичник(!) и прашалник (?). Исто така зборовите во текстот можат да се појават и со прва голема буква и во тој случај неговиот синоним на македонски јазик исто така треба да се отпечати со прва голема буква.

import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        HashMap<String,String> recnik = new HashMap<>();

        int n = scanner.nextInt();
        scanner.nextLine();
        for(int i=0; i<n; i++){
            String []input = scanner.nextLine().split(" ");
            String golemaBukvaKu = input[0].substring(0,1).toUpperCase() + input[0].substring(1);
            String golemaBukvaMk = input[1].substring(0,1).toUpperCase() + input[1].substring(1);

            recnik.putIfAbsent(input[0],input[1]);
            recnik.putIfAbsent(golemaBukvaKu,golemaBukvaMk);
        }
        String recenica = scanner.nextLine();

        for(String zbor : recnik.keySet()){
            recenica = recenica.replaceAll("\\b" + zbor + "\\b", recnik.get(zbor));
        }

        System.out.println(recenica);
    }
}
