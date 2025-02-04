//Да се напише алгоритам со коj ´ке се имплементира играта “Направи молекула
//на вода”. Во оваа игра на располагање имате два типа атоми (H-водород, и O-
//кислород). За да се направи молекула на вода (H2O) потребно е да имате два
//атоми на водород и еден атом на кислород. На почеток се генерира една случаjна
//секвенца од атоми. Ваша задача е од тоj влез, како доа´гаат атомите да генерирате
//молекули и да кажете колку такви молекули се креирале, и кои атоми останале
//несврзани.
//Влез: Во влезот е дадена секвенца од случаjни атоми
//Излез: На излез треба да се испечати броjот на молекули H2O, и несврзаните
//атоми од водород и кислород.

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stack<String> hydrogen = new Stack<>();
        Stack<String> oxygen = new Stack<>();

        int n = scanner.nextInt();
        for(int i=0; i<n; i++){
            String str = scanner.next();
            if(str.equals("H")){
                hydrogen.push(str);
            } else if(str.equals("O")){
                oxygen.push(str);
            }
        }

        int count = 0;
        while(hydrogen.size()>2 && oxygen.size()>1){
            hydrogen.pop();
            oxygen.pop();
            hydrogen.pop();

            count++;
        }

        ArrayList<String> remaining = new ArrayList<>();
        while(!hydrogen.isEmpty()){
            remaining.add(hydrogen.pop());
        }
        while(!oxygen.isEmpty()){
            remaining.add(oxygen.pop());
        }

        System.out.println(count);
        System.out.println(remaining);
    }
}
