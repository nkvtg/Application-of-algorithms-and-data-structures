//Додека Стефан ги потготвува испитите за полагање во jунска сесиjа, тоj има
//навика да ги чува сите книги на еден куп, една врз друга. При пребарување на
//дадена книга коjа му е потребна, тоj секогаш ги трга прво наjгорните, една по
//една, се додека не jа земе книгата коjа му треба. Штом ´ке jа извади таа книга,
//останатите кои биле над неа ги вра´ка во истиот редослед назад. Откако ´ке го
//научи дадениот предмет, jа вра´ка книгата одозгора врз сите други.
//Дадена е инициjалната поставеност на книгите на купот на Стефан (во редос-
//лед одоздола нагоре). Дадени се и испитите по распоред на полагање за jунска
//сесиjа. Ваша задача е да одредите колку пати секоjа од книгите ´ке биде извадена
//и ставена назад на купот.
//Влез: Во првата линиjа од влезот се дадени два броjа: М, броj на книги и N,
//броj на испити.
//Во втората линиjа од влезот се дадени имињата на книгите, подредени одоз-
//дола нагоре.
//Во третата линиjа од влезот се дадени испитите кои се полагаат по редослед.
//Излез: На излез треба да се испечати за секоjа книга колку пати ´ке биде
//земена и вратена назад на купот (еден „настан“ на земање-вра´кање на книгата
//се брои еднаш, не два пати). Имињата на книгите се печатат во исти редослед
//во коj биле дадени на влезот.

import java.util.*;

class Kniga {
    String name;
    int brVadenja;

    public Kniga(String name, int brVadenja) {
        this.name = name;
        this.brVadenja = brVadenja;
    }

    public void addVadenje() {
        this.brVadenja = brVadenja+1;
    }

    @Override
    public String toString() {
        return name + " " + brVadenja;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Kniga> pecatenje = new ArrayList<>();
        Stack<Kniga> knigi = new Stack<>();
        ArrayList<String> ispiti = new ArrayList<>();

        int m = scanner.nextInt();
        int n = scanner.nextInt();

        for(int i=0; i<m; i++){
            knigi.push(new Kniga(scanner.next(), 0));
            pecatenje.add(knigi.peek());
        }

        for(int i=0; i<n; i++){
            ispiti.add(scanner.next());
        }

        for(String ispit : ispiti){
            Stack<Kniga> izvadeni = new Stack<>();
            Boolean found = false;
            while(!found){
                Kniga kniga = knigi.pop();
                if(kniga.name.equals(ispit)){
                    while(!izvadeni.isEmpty()){
                        knigi.push(izvadeni.pop());
                    }
                    knigi.push(kniga);
                    found = true;
                }

                izvadeni.add(kniga);
                kniga.addVadenje();
            }
        }


        for(Kniga kniga :pecatenje){
            System.out.println(kniga);
        }
    }
}
