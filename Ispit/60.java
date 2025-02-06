//Во заводот на статистика се прави ново истражување каде што се открива за-
//висноста на месецот на ра´гање со имињата на лу´гето родени во тоj месец. Ваша
//задача е за даден месец да ги прикажете сите различни имиња на лу´ге родени
//во тоj месец.
//Влез: Во првиот ред од влезот е даден броjот на лу´ге 𝑁 (𝑁 <= 10000), а
//во секоj нареден ред се дадени името на човекот и датумот на неговото ра´гање,
//разделени со празно место. Во последниот ред е даден месецот за коj треба да
//се прикажат сите различни имиња на лу´гето родени во тоj месец.
//Излез: Листа со различни имиња на лу´ге родени во дадениот месец. Доколку
//нема лу´ге родени во тоj месец да се испечати „Empty”.

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String,ArrayList<String>> names = new HashMap<>();

        int n = scanner.nextInt();
        for(int i=0;i<n;i++){
            String name = scanner.next();
            String []month = scanner.next().split("\\.");

            names.putIfAbsent(month[1],new ArrayList<>());
            if(!names.get(month[1]).contains(name)){
                names.get(month[1]).add(name);
            }
        }

        String month = scanner.next();

        if(!names.containsKey(month) || names.get(month).isEmpty()){
            System.out.println("Empty");
        } else {
            names.get(month).forEach(name->System.out.print(name+" "));
        }
    }
}
