//На влез во оваа задача ќе ви бидат дадени редови како следниот формат:
//Ime Prezime budzhet ip_adresa vreme grad cena
//Пример
//Jovan Todorov 1000 10.73.112.200 15:30 Bitola 760
//Кое што значи дека лицето со Име и Презиме Jovan Todorov, има буџет од 1000 денари, има IP адреса со мрежа 10.73.112 и домаќин (host number) 200, и се приклучил во 15:30 часот за да купи билет кон Bitola кој што чини 760 денари.
//
//Ќе ви бидат дадени N такви редови, по што ќе следи празен ред па уште M редови од истиот формат, кои ќе ги користиме за тестирање.
//
//Од редот за тестирање треба да ја извадите IP адресата на мрежата и потоа да го одговорите следното прашање со оваа мрежа:
//
//Од сите N лица на влез, кои што се поврзуваат со истата мрежа (од било кој домаќин во мрежата)
//колку од нив се вклучиле подоцна од 11:59; и
//од овие, кој од нив се вклучил најрано? 
//(погледнете го тест примерот!)
//
//(доколку има повеќе со исто најмало време тогаш кој е првиот таков во влезот?) (секогаш ќе постои барем еден таков)
//
//Ова ќе треба да го направите за сите M редови за тестирање!

import java.util.*;

class Person{
    String name;
    int budget;
    String ip;
    String time;
    int timeMinutes;
    String city;
    int price;

    public Person(String name, int budget, String ip, String time, int timeMinutes, String city, int price) {
        this.name = name;
        this.budget = budget;
        this.ip = ip;
        this.time = time;
        this.timeMinutes = timeMinutes;
        this.city = city;
        this.price = price;
    }

    public static Comparator<Person> comparator = Comparator.comparing(p -> p.timeMinutes);

    @Override
    public String toString() {
        return name+" with salary "+budget+" from address "+ip+" who logged in at "+time;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String,ArrayList<Person>> map = new HashMap<>();

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String name = scanner.next()+" "+scanner.next();
            int budget = scanner.nextInt();
            String ip = scanner.next();
            String []temp = ip.split("\\.");
            String network = temp[0]+"."+temp[1]+"."+temp[2];
            String time = scanner.next();
            String []temp2 = time.split(":");
            int timeMinutes = Integer.parseInt(temp2[0])*60+Integer.parseInt(temp2[1]);
            String city = scanner.next();
            int price = scanner.nextInt();


            if(timeMinutes>= 11*60+59){
                map.putIfAbsent(network,new ArrayList<>());
                map.get(network).add(new Person(name,budget,ip,time,timeMinutes, city,price));
                map.get(network).sort(Person.comparator);
            }
        }

        ArrayList<String> networks = new ArrayList<>();
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            scanner.next();
            scanner.next();
            scanner.nextInt();
            String ip = scanner.next();
            String []temp = ip.split("\\.");
            String network = temp[0]+"."+temp[1]+"."+temp[2];
            scanner.next();
            scanner.next();
            scanner.nextInt();

            networks.add(network);
        }

        networks.forEach(network->{
            System.out.println("IP network: "+network+" has the following number of users:");
            System.out.println(map.get(network).size());
            System.out.println("The user who logged on earliest after noon from that network is:");
            System.out.println(map.get(network).get(0));
            System.out.println();
        });
    }

}
