//Библиотека е посетена од студентите со цел да изнајмат еден или повеќе типови на книги. Дадена книга може да припаѓа на една од трите категории: Наука, Научна фантастика или Историја. Кога библиотеката ќе започне со работа првин се услужени студентите кои чекаат ред за книга од тип Наука, потоа студентите кои чекаат ред за книга од тип научна фантастика и на крај студентите кои чекаат ред за книга од тип Историја.
//Доколку студент чека ред за книги од различен тип, тој чека ред првин во редицата за книга од тип Наука, потоа во редицата за книга од тип Научна фантастика и на крај во редицата за книга од тип Историја (во зависност ако ги бара овие книги за позајмување).
//
//Влез: Во првата линија е даден број на студенти кои имаат дојдено во библиотеката да позајмат книга. Потоа 4 редици се внесуваат за секој студент, каде првата линија е име на студент, а во останатите 3 редици се внесува дали студентот ќе позајми книга од даден тип (Наука, Научна фантастика и Историја соодветно), каде 1 значи дека има за цел да позајми книга од тој тип, 0 значи дека нема да позајми книга од тој тип.
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
}

public class Main {
    public static void checkIfFinished(Student student, ArrayList<String> finished){
        if(student.nauka == 0 && student.naucnaFantastika == 0 && student.istorija == 0){
            finished.add(student.name);
        }
    }

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
        while(!nauka.isEmpty()){
            int index = students.indexOf(nauka.poll());
            students.get(index).nauka = 0;
               if(students.get(index).naucnaFantastika == 1){
                   naucnaFantastika.add(students.get(index));
               } else if(students.get(index).istorija == 1){
                   istorija.add(students.get(index));
               }
               checkIfFinished(students.get(index),finished);

        }

        while(!naucnaFantastika.isEmpty()){
            int index = students.indexOf(naucnaFantastika.poll());
            students.get(index).naucnaFantastika = 0;
            if(students.get(index).istorija == 1){
                istorija.add(students.get(index));
            }
            checkIfFinished(students.get(index),finished);

        }

        while(!istorija.isEmpty()){
            int index = students.indexOf(istorija.poll());
            students.get(index).istorija = 0;
            checkIfFinished(students.get(index),finished);

        }

        for(int i=0; i<n; i++){
            System.out.println(finished.get(i));
        }
    }
}
