//Да се напише алгоритам со коj ´ке се имплементира играта “Поништување топчи-
//ња”. Во оваа игра на располагање имате топчиња во три различни бои (R-црвена,
//G-зелена и B-сина), обележани со знакот + или -. Поништување на топчиња мо-
//же да настане само доколку тие се од иста боjа и со спротивен знак. На почеток
//се генерира една случаjна листа со топчиња. Ваша задача е од тоj влез, како
//доа´гаат топчињата да направите поништување и да кажете колку, од каков тип
//(+ или -) и од коjа боjа фалат за да се поништат сите топчиња од влезот.
//Влез: Во влезот е дадена листа од случаjни топчиња и тоа во облик: боjа,
//знак.
//Излез: На излез треба да се испечатат броjот на парови и паровите кои може
//да се формираат.

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stack<String> red = new Stack<>();
        Stack<String> green = new Stack<>();
        Stack<String> blue = new Stack<>();

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String str = scanner.next();
            if(str.contains("R")){
                red.push(str);
            } else if(str.contains("G")){
                green.push(str);
            } else if(str.contains("B")){
                blue.push(str);
            }
        }

        HashMap<String,ArrayList<String>> pairs = new HashMap<>();

        while(!red.isEmpty()){
            String s = red.pop();
            if(s.contains("+")){
                pairs.putIfAbsent("red+",new ArrayList<>());
                pairs.get("red+").add(s);
            } else if(s.contains("-")){
                pairs.putIfAbsent("red-",new ArrayList<>());
                pairs.get("red-").add(s);
            }
        }

        while(!green.isEmpty()){
            String s = green.pop();
            if(s.contains("+")){
                pairs.putIfAbsent("green+",new ArrayList<>());
                pairs.get("green+").add(s);
            } else if(s.contains("-")){
                pairs.putIfAbsent("green-",new ArrayList<>());
                pairs.get("green-").add(s);
            }
        }

        while(!blue.isEmpty()){
            String s = blue.pop();
            if(s.contains("+")){
                pairs.putIfAbsent("blue+",new ArrayList<>());
                pairs.get("blue+").add(s);
            } else if(s.contains("-")){
                pairs.putIfAbsent("blue-",new ArrayList<>());
                pairs.get("blue-").add(s);
            }
        }

        ArrayList<String> notPairs = new ArrayList<>();
        int count = 0;

        if(pairs.get("red+").size() != pairs.get("red-").size()){
            int diff = Math.abs(pairs.get("red+").size() - pairs.get("red-").size());
            count += diff;

            String tmp = "";
            if(pairs.get("red+").size() > pairs.get("red-").size()){
                tmp = "R-";
            } else {
                tmp = "R+";
            }

            for(int i=0; i<diff; i++){
                notPairs.add(tmp);
            }
        }

        if(pairs.get("green+").size() != pairs.get("green-").size()){
            int diff = Math.abs(pairs.get("green+").size() - pairs.get("green-").size());
            count += diff;

            String tmp = "";
            if(pairs.get("green+").size() > pairs.get("green-").size()){
                tmp = "G-";
            } else {
                tmp = "G+";
            }

            for(int i=0; i<diff; i++){
                notPairs.add(tmp);
            }
        }

        if(pairs.get("blue+").size() != pairs.get("blue-").size()){
            int diff = Math.abs(pairs.get("blue+").size() - pairs.get("blue-").size());
            count += diff;

            String tmp = "";
            if(pairs.get("blue+").size() > pairs.get("blue-").size()){
                tmp = "B-";
            } else {
                tmp = "B+";
            }

            for(int i=0; i<diff; i++){
                notPairs.add(tmp);
            }
        }

        System.out.println(count);
        System.out.println(notPairs);
    }
}
