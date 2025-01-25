//Дадени се N задачи кои треба да се изработат. За секоја од задачите го знаеме времето за изработка (во часови) и заработката која ја носи. Да се најде максималната заработка во рок од една 40 часовна работна недела. Напомена дека и делумно сработени задачи носат делумна заработка, во зависност од процентот на завршеност.
//
//Влез: Првиот број од влезот е бројот на задачи N, а потоа во следниот ред времетраењето на задачата во часови и заработката која ја носи.
//Излез: Максимална заработка која можеме да ја направиме за 40 часа.


import java.util.*;

class Job {
    int time;
    int earnings;
    double ratio;

    public Job(int time, int earnings) {
        this.earnings = earnings;
        this.time = time;
        this.ratio = (double)earnings / (double)time;
    }

    @Override
            public String toString() {
        return time + " " + earnings + " " + ratio;
    }

    public static Comparator<Job> comparator = Comparator.comparing(c -> c.ratio);
}

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        ArrayList<Job> jobs = new ArrayList<>();

        int n = scanner.nextInt();
        for(int i=0; i<n; i++){
            jobs.add(new Job(scanner.nextInt(), scanner.nextInt()));
        }

        jobs.sort(Job.comparator.reversed());

        int totalEarnings = 0;
        int totalHours = 0;

        for(Job job : jobs){
            if(job.time+totalHours <= 40){
                totalEarnings += job.earnings;
                totalHours += job.time;
            } else {
                totalEarnings += job.ratio*(40-totalHours);
                break;
            }
        }

        System.out.println(totalEarnings);
    }
}
