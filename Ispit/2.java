//За даден збор кој се внесува од стандарден влез, да се испечати истиот превртен. На влез во првиот ред се дава број на зборови кои ќе се внесуваат. Во наредните линии се внесуваат самите зборови.
//
//For example:
//Input
//3
//one two three
//
//Result
//eno owt eerht

import java.util.*;

class ReverseWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer n = scanner.nextInt();
        ArrayList<StringBuilder> strings = new ArrayList<>();

        for(int i=0; i<n; i++){
            strings.add(new StringBuilder(scanner.next()));
        }

        strings.forEach(string -> {
            string.reverse();

            System.out.println(string);
        });
    }
}
