import java.util.Scanner;

class QuarterlySales {

    private int numOfSales;
    private int [] revenues;
    private int quarterNo;

    public QuarterlySales(int numOfSales, int[] revenues, int quarterNo) {
        this.numOfSales = numOfSales;
        this.revenues = revenues;
        this.quarterNo = quarterNo;
    }
    @Override
    public String toString() {
        return "Ne znam sho e fintata";
    }

    public int[] getRevenues() {
        return revenues;
    }

    public int getNumOfSales() {
        return numOfSales;
    }

    public void print() {
        int sum = 0;
        for(int i=0; i<numOfSales; i++) {
            sum += revenues[i];
        }
        System.out.print("   " + sum);
    }
}

class SalesPerson {

    private String name;
    private QuarterlySales [] quarters;

    public SalesPerson(String name, QuarterlySales[] quarters) {
        this.name = name;
        this.quarters = quarters;
    }
    @Override
    public String toString() {
        return "Sho mu e poentata";
    }

    public int sumSales(SalesPerson sp) {
        int sum = 0;
        for(int i=0; i<4; i++) {
            for(int j=0; j<sp.quarters[i].getNumOfSales(); j++) {
                sum += sp.quarters[i].getRevenues()[j];
            }
        }
        return sum;
    }
    public String getName() {
        System.out.println();
        return name;
    }

    public void print() {
        System.out.print(name);
        for(int i=0; i<4; i++) {
            quarters[i].print();
        }
        System.out.println("   " + sumSales(this));
    }
}



public class Main {

    public static SalesPerson salesChampion(SalesPerson [] arr)
    {
        SalesPerson champion = arr[0];
        for(int i=0; i<arr.length; i++) {
            if(champion.sumSales(champion)<arr[i].sumSales(arr[i])){
                champion = arr[i];
            }
        }
        return champion;
    }
    public static void table(SalesPerson [] arr)
    {
        System.out.println("SP   1   2   3   4   Total");
        for(int i=0; i<arr.length; i++) {
            arr[i].print();
        }

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        SalesPerson [] arr = new SalesPerson[n];
        for(int i=0;i<n;i++)
        {
            QuarterlySales []quarters = new QuarterlySales[4];
            String name = input.next();
            for(int j=0; j<4; j++) {
                int numOfSales = input.nextInt();
                int []revenues = new int[numOfSales];
                for(int k=0; k<numOfSales; k++) {
                    revenues[k] = input.nextInt();
                }
                quarters[j] = new QuarterlySales(numOfSales, revenues, j);
            }
            arr[i] = new SalesPerson(name, quarters);
        }

        table(arr);
        System.out.println("SALES CHAMPION: " + salesChampion(arr).getName());

    }
}
