//Даден е код на модифициран програмски јазик каде функциите се претставени со отворен и затворен таг ("imeFunkcija" и "endimeFunkcija"). Ваша задача е да дефинирате дали даден програмски код е валиден.
//
//Пример валиден код:
//func1
//func2
//endfunc2
//func3
//endfunc3
//endfunc1
//
//Пример невалиден код (испуштен е затворен таг за func3):
//func1
//func2
//endfunc2
//func3
//endfunc1
//
//Влез: Код со модифициран програмски јазик, каде секој таг е напишан во нов ред. Се внесуваат тагови се додека не се внесе "x".
//Излез: "Valid" - доколку е валиден кодот, "Invalid" - доколку не е валиден кодот.

import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        Stack<String> stack = new Stack<>();


        while(true){
            String input = scanner.next();
            if(input.equals("x")){
                break;
            }
            stack.push(input);
        }

        boolean valid = true;

        ArrayList<String> start = new ArrayList<>();
        ArrayList<String> end = new ArrayList<>();

        while(!stack.isEmpty()){
            String s = stack.pop();
            if(s.startsWith("end")){
                String ss = s.replace("end","");
                end.add(ss);
            } else {
                start.add(s);
            }
        }

        start.sort(Comparator.naturalOrder());
        end.sort(Comparator.naturalOrder());

        if(!start.equals(end)){
            valid = false;
        }

        System.out.println(valid ? "Valid" : "Invalid");
    }
}
