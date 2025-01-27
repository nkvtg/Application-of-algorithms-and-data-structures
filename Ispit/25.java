//Библиотека е посетена од студентите со цел да изнајмат еден или повеќе типови на книги. Дадена книга може да припаѓа на една од трите категории: Наука, Научна фантастика или Историја. Кога библиотеката ќе започне со работа се услужуваат студенти од сите три типа паралелно, но исто така сите три шалтера не одат со иста брзина па услужувањето е со следниот редослед (два студента што ги бараат книга од тип Наука, па еден студент што бара книга од тип Научна фантастика, па два студенат што бараат книга од тип Историја).
//Доколку студент чека ред за книги од различен тип, тој чека ред првин во редицата за книга од тип Наука, потоа во редицата за книга од тип Научна фантастика и на крај во редицата за книга од тип Историја (во зависност ако ги бара овие книги за позајмување).
//
//Влез: Во првата линија е даден број на студенти кои имаат дојдено во библиотеката да позајмат книга. Потоа 4 редици се внесуваат за секој студент, каде првата линија е име на студент, а во останатите 3 редици се внесува дали студентот ќе позајми книга од даден тип (Наука, Научна фантастика и Историја соодветно), каде 1 значи дека има за цел да позајми книга од тој тип, 0 значи дека нема да позајми книга од тој тип.
//
//Пример:
//Иван Ивановски
//1
//1
//0
//значи дека студентот Иван Ивановски има за цел да позајми книга од тип Наука и тип Научна фантастика, но не има за цел да позајми книга од тип Историја.
//
//Излез: Испечати го редоследот на студентите по редослед како завршуваат со позајмување на сите книги.

import java.util.*;

class Student {
    String name;
    int nauka;
    int naucnaFantastika;
    int istorija;

    public Student(String name, int nauka, int naucnaFantastika, int istorija) {
        this.name = name;
        this.nauka = nauka;
        this.naucnaFantastika = naucnaFantastika;
        this.istorija = istorija;
    }

    public boolean isFinished(){
        return nauka == 0 && naucnaFantastika == 0 && istorija == 0;
    }
}

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();

        Queue<Student> nauka = new LinkedList<>();
        Queue<Student> naucnaFantastika = new LinkedList<>();
        Queue<Student> istorija = new LinkedList<>();

        int n  = scanner.nextInt();
        scanner.nextLine();

        for(int i = 0; i < n; i++){
            String name = scanner.nextLine().trim();
            int inputNauka = scanner.nextInt();
            int inputNFantastika = scanner.nextInt();
            int inputIstorija = scanner.nextInt();
            scanner.nextLine();

            students.add(new Student(name,inputNauka,inputNFantastika,inputIstorija));
            if(students.get(i).nauka == 1){
                nauka.add(students.get(i));
            } else if(students.get(i).naucnaFantastika == 1){
                naucnaFantastika.add(students.get(i));
            } else if(students.get(i).istorija == 1){
                istorija.add(students.get(i));
            }
        }

        ArrayList<String> finished = new ArrayList<>();
        while(!nauka.isEmpty() || !naucnaFantastika.isEmpty() || !istorija.isEmpty()){
            for(int i=0; i<2; i++){
                if(!nauka.isEmpty()){
                    int index = students.indexOf(nauka.poll());
                    students.get(index).nauka = 0;
                    if(students.get(index).isFinished()){
                        finished.add(students.get(index).name);
                    } else {
                        if(students.get(index).naucnaFantastika == 1){
                            naucnaFantastika.add(students.get(index));
                        } else if(students.get(index).istorija == 1){
                            istorija.add(students.get(index));
                        }
                    }
                }
            }

            if (!naucnaFantastika.isEmpty()){
                int index = students.indexOf(naucnaFantastika.poll());
                students.get(index).naucnaFantastika = 0;
                if(students.get(index).isFinished()){
                    finished.add(students.get(index).name);
                }  else {
                    if(students.get(index).istorija == 1){
                        istorija.add(students.get(index));
                    }
                }
            }

            for(int i=0; i<2; i++){
                if(!istorija.isEmpty()){
                    int index = students.indexOf(istorija.poll());
                    students.get(index).istorija = 0;
                    if(students.get(index).isFinished()){
                        finished.add(students.get(index).name);
                    }
                }
            }
        }

        for(int i=0; i<n; i++){
            System.out.println(finished.get(i));
        }
    }
}
