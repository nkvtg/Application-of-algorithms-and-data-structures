//Даден е стринг. Треба да се најде најчестиот под-стринг кој е дел од него и да се испечати. Доколку два под-стринга се исто фреквентни, тогаш се печати подолгиот. Доколку и овој услов го исполнуваат тогаш се печати лексикографски помалиот.
//
//Пример: За стрингот "abc" под-стрингови се "a", "b", "c", "ab", "bc", "abc". Сите имаат иста честота па затоа се печати најдолгиот "abc".

import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        HashMap<String,ArrayList<String>> map = new HashMap<>();
        String input = scanner.nextLine();

        for(int i=0; i<input.length(); i++){
            for(int j=i+1; j<=input.length(); j++){
                String str = input.substring(i,j);
                map.putIfAbsent(str, new ArrayList<>());
                map.get(str).add(str);
            }
        }

        String mostFrequent = "";
        int maxFrequency = 0;

        for(String substr : map.keySet()){
            if(map.get(substr).size() > maxFrequency || (map.get(substr).size() == maxFrequency && substr.length() > mostFrequent.length())){
                maxFrequency = map.get(substr).size();
                mostFrequent = substr;
            }
        }

        System.out.println(mostFrequent);
    }
}
