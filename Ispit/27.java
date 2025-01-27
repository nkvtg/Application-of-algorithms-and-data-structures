//Студентска служба е посетена од студентите со цел да приложат/земат документи. Студентот може да приложи документи, да побара да си го земе индексот или пак да побара да си ги земе документите од средно. Кога студентската служба ќе започне со работа се услужуваат студенти од сите три типа паралелно, но исто така сите три шалтера не одат со иста брзина па услужувањето е со следниот редослед (два студента што ги приложуваат документите, па три студенти што сакаат да си го земат индексот, па еден студент што сака да си ги земе документите од средно).
//Доколку студент чека ред за повеќе услуги кај студентската служба, тој чека ред првин во редицата за приложување на документи, потоа во редицата за земање на индекс и на крај во редицата за земање на документи од средно.
//
//Влез: Во првата линија е даден број на студенти кои имаат дојдено за да бидат услужени од студентската служба. Потоа 4 редици се внесуваат за секој студент, каде првата линија е име на студент, а во останатите 3 редици се внесува дали има потреба од дадена услуга (приложување документи, земање на индекс, земање на документи од средно соодветно), каде 1 значи дека има потреба од услуга од тој тип, 0 значи дека нема потреба од услуга од тој тип.
//
//Пример:
//
//Иван Ивановски
//1
//1
//0
//значи дека студентот Иван Ивановски има за цел да приложи документи и да си го земе индексот.
//
//Излез: Испечати го редоследот на студентите по редослед како завршуваат со сите услуги од студенстката служба.

import java.util.*;

class Student {
    String name;
    int prilozuvanjeDokumenti;
    int zemanjeIndeks;
    int zemanjeDokumenti;

    public Student(String name, int prilozuvanjeDokumenti, int zemanjeIndeks, int zemanjeDokumenti) {
        this.name = name;
        this.prilozuvanjeDokumenti = prilozuvanjeDokumenti;
        this.zemanjeIndeks = zemanjeIndeks;
        this.zemanjeDokumenti = zemanjeDokumenti;
    }

    public boolean isFinished(){
        return prilozuvanjeDokumenti==0 && zemanjeIndeks==0 && zemanjeDokumenti==0;
    }
}

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();

        Queue<Student>prilozuvanjeDokumenti = new LinkedList<>();
        Queue<Student>zemanjeIndeks = new LinkedList<>();
        Queue<Student>zemanjeDokumenti = new LinkedList<>();

        int n = scanner.nextInt();
        scanner.nextLine();
        for(int i=0; i<n; i++){
            String name = scanner.nextLine();
            int inputPrilozuvanjeDokumenti = scanner.nextInt();
            int inputZemanjeIndeks = scanner.nextInt();
            int inputZemanjeDokumenti = scanner.nextInt();
            scanner.nextLine();

            students.add(new Student(name, inputPrilozuvanjeDokumenti, inputZemanjeIndeks, inputZemanjeDokumenti));
            if(inputPrilozuvanjeDokumenti == 1){
                prilozuvanjeDokumenti.add(students.get(i));
            } else if (inputZemanjeIndeks == 1){
                zemanjeIndeks.add(students.get(i));
            } else if (inputZemanjeDokumenti ==1){
                zemanjeDokumenti.add(students.get(i));
            }
        }

        ArrayList<String> finished = new ArrayList<>();
        while(!prilozuvanjeDokumenti.isEmpty() || !zemanjeIndeks.isEmpty() || !zemanjeDokumenti.isEmpty()){

            for(int i=0; i<2; i++){
                if(!prilozuvanjeDokumenti.isEmpty()){
                    int index = students.indexOf(prilozuvanjeDokumenti.poll());
                    students.get(index).prilozuvanjeDokumenti = 0;
                    if(students.get(index).isFinished()){
                        finished.add(students.get(index).name);
                    } else {
                        if(students.get(index).zemanjeIndeks==1){
                            zemanjeIndeks.add(students.get(index));
                        } else if(students.get(index).zemanjeDokumenti==1){
                            zemanjeDokumenti.add(students.get(index));
                        }
                    }
                }
            }

            for(int i=0; i<3; i++){
                if(!zemanjeIndeks.isEmpty()){
                    int index = students.indexOf(zemanjeIndeks.poll());
                    students.get(index).zemanjeIndeks = 0;
                    if(students.get(index).isFinished()){
                        finished.add(students.get(index).name);
                    } else {
                        if(students.get(index).zemanjeDokumenti==1){
                            zemanjeDokumenti.add(students.get(index));
                        }
                    }
                }
            }

            if(!zemanjeDokumenti.isEmpty()){
                int index = students.indexOf(zemanjeDokumenti.poll());
                students.get(index).zemanjeDokumenti = 0;
                if(students.get(index).isFinished()){
                    finished.add(students.get(index).name);
                }
            }
        }

        for(int i=0; i<n; i++){
            System.out.println(finished.get(i));
        }
    }
}
