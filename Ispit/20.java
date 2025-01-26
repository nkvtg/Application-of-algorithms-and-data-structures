//Дадена е низа од „речиси“ сортирани броеви во растечки редослед, во смисол дека во сортирана низа има неколку залутани броеви кои се надвор од редоследот. Залутаните броеви се секогаш мали броеви кои се наоѓаат подесно од нивното вистинско место.
//Ваша задача е да ги најдете залутаните броеви, како и бројот на места што залутаниот број треба да се помести во лево за низата да биде сортирана.
//НАПОМЕНА: Оптималното решение има сложеност помала од квадратна
//
//Влез:
//Во првиот ред е даден број N, големината на низата
//Во наредните N редови се дадени броевите од низата.
//Излез:
//Во првиот ред се печати M, бројот на залутани броеви.
//Во наредните M редови, се печати секој залутан број, како и бројот на места за кои треба да биде поместен во лево.
//
//Забелешка: Залутаните броеви се растечки подредени еден во однос на друг, во смисол дека залутан број при поместување на лево нема да премине преку друг залутан број.

import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> sortedArr = new ArrayList<>();

        for(int i=0; i<n; i++){
            int num = scanner.nextInt();
            arr.add(num);
            sortedArr.add(num);
        }

        Collections.sort(sortedArr);

        int found = 0;
        ArrayList<Integer[]> map = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(!arr.get(i).equals(sortedArr.get(i))){
                int correctIndex = Collections.binarySearch(sortedArr, arr.get(i));
                if(correctIndex < i){
                    map.add(new Integer[] {arr.get(i), i-correctIndex});
                    found++;
                }
            }
        }

        System.out.println(found);
        for(int i=0; i<found; i++){
            System.out.print(map.get(i)[0] + " ");
            System.out.print(map.get(i)[1]);
            System.out.println();
        }
    }
}
