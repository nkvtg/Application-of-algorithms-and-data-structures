//За различни градови дадени се мерењата на температурата (степени Целзиусо-
//ви) во одредени временски интервали. Ваша задача е за даден град да се наjде
//наjтоплиот период од денот.
//Влез: Во првиот ред од влезот е даден броjот на мерења 𝑁 (𝑁 <= 10000),
//а во секоj нареден ред е даден прво градот, потоа почеток на интервал, краj на
//интервал и температурата разделени со празно место. Во последниот ред е даден
//градот за коj треба да наjдете наjтопол период од денот и истиот период да се
//испечати. Сложеноста на оваа операциjа треба да биде O(1).
//Излез: Наjтоплиот период од денот за даден град. Да се испечати во след-
//ниов формат: G: HH:MM – XX:YY Z, каде што G е градот, HH:MM e почетокот
//на интервалот, XX:YY е краjот на интервалот, а Z e температурата во степени
//Целзиусови.

import java.util.*;

class Temperature {
    String city;
    String startInterval;
    String endInterval;
    Float temperature;

    public Temperature(String city, String startInterval, String endInterval, Float temperature) {
        this.city = city;
        this.startInterval = startInterval;
        this.endInterval = endInterval;
        this.temperature = temperature;
    }

    public static Comparator<Temperature> comparator = Comparator.comparing(c -> c.temperature);

    @Override
    public String toString() {
        return city+": "+startInterval+" - "+endInterval+" "+temperature;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String,ArrayList<Temperature>> cities = new HashMap<>();

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String city = scanner.next();
            String startInterval = scanner.next();
            String endInterval = scanner.next();
            Float temperature = scanner.nextFloat();

            cities.putIfAbsent(city, new ArrayList<>());
            cities.get(city).add(new Temperature(city, startInterval, endInterval, temperature));
            cities.get(city).sort(Temperature.comparator.reversed());
        }

        String checkCity = scanner.next();
        System.out.println(cities.get(checkCity).get(0));
    }
}
