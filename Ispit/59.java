//Даден е телефонски именик од вашиот мобилен телефон. Во тоj телефонски
//именик за секоj броj е дадено името на сопственикот. Некои телефони при повик
//го даваат целосниот броj (заедно со повикувачкиот броj на земjата, на пример за
//Македониjа +389 X XXX XXX), а некои само локалниот броj (0XX XXX XXX).
//Ова значи дека ако во некои телефони броjот започнува со +389, во други би
//започнувал само со 0. Ваша задача е независно од тоа како вашиот мобилен броj
//го прикажува броjот да го пронаjдете сопственикот на броjот. Доколку го нема,
//треба да испечатите: „Unknown number”.
//Влез: Во првиот ред е даден броj на мобилни броеви 𝑁 . Во следните 𝑁 редови
//се дадени броеви (во формат 0XXXXXXXX) и нивните сопственици разделени
//со празно место. Во последниот ред е даден броjот за коj треба да го одредите
//сопственикот.
//Излез: Се печати сопственикот за дадениот броj или „Unknown number” до-
//колку го нема дадениот броj во именикот.

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String,String> phoneNumbers = new HashMap<>();

        int n = scanner.nextInt();
        for(int i = 0;i<n;i++) {
            String number = scanner.next().replaceFirst("0","+389");
            String name = scanner.next();

            phoneNumbers.put(number,name);
        }

        String check = scanner.next();

        if(phoneNumbers.get(check)!=null) {
            System.out.println(phoneNumbers.get(check));
        } else {
            System.out.println("Unknown number");
        }
    }
}
