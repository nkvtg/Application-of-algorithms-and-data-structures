//Информациите за организациjата на датотечниот систем на серверот на ФИНКИ
//се зачувани во хеш табела. За секоjа датотека се знае неjзината содржина и
//патеката на коjа се нао´га. Ваша задача е да ги наjдете сите датотеки кои имаат
//идентична содржина.
//Влез: Во првиот ред е даден броjот на датотеки 𝑁 . Во следните 𝑁 редици се
//дадени податоци за секоjа датотека во формат „path file (content)”, каде што path
//е патеката на директориумот во коj се нао´га датотеката, file е називот на дато-
//теката заедно со наставката и content е содржината на датотеката. Во следниот
//ред е даден броj на команди 𝑀 . Во следните 𝑀 редици се дадени команди во
//формат „cmd path file (content)” каде што cmd може да биде add, delete или find.
//Командата add треба да jа додаде датотеката file со содржина content во дирек-
//ториумот коj се нао´га на патеката path. Командата delete треба да jа избрише
//датотеката file со содржина content од директориумот коj се нао´га на патеката
//path. Командата find треба да провери дали постои датотеката file со содржина
//content во директориумот со патека path и да испечати на екран „true” или „false”.
//Во последната редица од влезот е дадена содржината content.
//Излез: Листа од сите патеки на сите датотеките со содржина content.

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String,ArrayList<String>> map = new HashMap<>();

        int n = scanner.nextInt();
        for(int i=0; i<n; i++){
            String path = scanner.next();
            String file = scanner.next() + " " + scanner.next();
            map.putIfAbsent(path,new ArrayList<>());
            map.get(path).add(file);
        }

        int m = scanner.nextInt();
        for(int i=0; i<m; i++){
            String input = scanner.next();
            if(input.equals("add")){
                String path = scanner.next();
                String file = scanner.next() + " " + scanner.next();
                map.putIfAbsent(path,new ArrayList<>());
                map.get(path).add(file);
            } else if(input.equals("delete")){
                String path = scanner.next();
                String file = scanner.next() + " " + scanner.next();

                map.get(path).remove(file);

            } else if(input.equals("find")){
                String path = scanner.next();
                String file = scanner.next() + " " + scanner.next();

                if(map.get(path).contains(file)){
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            }
        }

        String text = scanner.next();

        map.forEach((key,value) -> value.forEach(entry -> {
            if(entry.contains(text)){
                String []temp = entry.split(" ");
                String file = temp[0];
                System.out.println(key+" "+file);
            }
        }));
    }

}
