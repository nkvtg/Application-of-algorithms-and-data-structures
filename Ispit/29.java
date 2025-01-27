//На влез во оваа задача ќе ви бидат дадени редови како следниот формат:
//Ime Prezime budzhet ip_adresa vreme grad cena
//Пример
//Jovan Todorov 1000 10.73.112.200 15:30 Bitola 760
//Кое што значи дека лицето со Име и Презиме Jovan Todorov, има буџет од 1000 денари, има IP адреса со мрежа 10.73.112 и домаќин (host number) 200, и се приклучил во 15:30 часот за да купи билет кон Bitola кој што чини 760 денари.
//
//Ќе ви бидат дадени N такви редови, по што ќе следи празен ред па уште M редови од истиот формат, кои ќе ги користиме за тестирање.
//
//Од редот за тестирање треба да го извадите градот и потоа да го одговорите следното прашање со овој град:
//
//Од сите N лица на влез, кои купуваат билет за до истиот град
//колку од нив се вклучиле подоцна од 11:59; и
//од овие, кој од нив се вклучил најрано?
//(погледнете го тест примерот!)
//
//(доколку има повеќе со исто најмало време тогаш кој е првиот таков во влезот?) (секогаш ќе постои барем еден таков)
//
//
//
//Ова ќе треба да го направите за сите M редови за тестирање!
//
//Препорака, користете OBHT и/или CBHT.

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

class Person {
    String name;
    int budget;
    String address;
    String time;
    String city;
    int price;
    int minutes;

    public Person(String name, int budget, String address, String time, String city, int price) {
        this.name = name;
        this.budget = budget;
        this.address = address;
        this.time = time;
        this.city = city;
        this.price = price;

        String []s = time.split(":");
        this.minutes = Integer.parseInt(s[0])*60+Integer.parseInt(s[1]);
    }

    @Override
    public String toString(){
        return name+" with salary "+budget+" from address "+address+" who logged in at "+time;
    }
}

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        HashMap<String,ArrayList<Person>> map = new HashMap<>();

        int n = scanner.nextInt();
        scanner.nextLine();
        for(int i=0; i<n; i++){
            String []input = scanner.nextLine().split("\\s+");
            String name = input[0]+" "+input[1];
            int budget = Integer.parseInt(input[2]);
            String address = input[3];
            String time = input[4];
            String city = input[5];
            int price = Integer.parseInt(input[6]);


            Person person = new Person(name,budget,address,time,city,price);

            map.putIfAbsent(city, new ArrayList<>());
            map.get(city).add(person);
        }

        ArrayList<String> cities = new ArrayList<>();
        int m = scanner.nextInt();
        scanner.nextLine();
        for(int i=0; i<m; i++){
            String []input = scanner.nextLine().split("\\s+");
            cities.add(input[5]);
        }

        cities.forEach(city -> {
            int earliestMinutes = 11*60+59;
            int numCustomers = 0;
            Person min = new Person("", 0, "", "23:59", "", 0);
            for(Person person : map.get(city)){
                if(person.minutes >= earliestMinutes){
                    numCustomers++;
                    if(person.minutes<min.minutes){
                        min=person;
                    }
                }
            }

            System.out.println("City: "+city+" has the following number of customers:");
            System.out.println(numCustomers);
            System.out.println("The user who logged on earliest after noon from that city is:");
            System.out.println(min);
            System.out.println();
        });
    }
}
