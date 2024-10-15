import java.util.Scanner;

public class PushZero
{
    static void pushZerosToBeginning(int arr[], int n)
    {
        int []temp = new int[n];
        int k = 0;
        for(int i=0; i<n; i++) {
            if(arr[i]==0) {
                temp[k++]=arr[i];
            }
        }
        for(int i=0; i<n; i++) {
            if(arr[i]!=0) {
                temp[k++]=arr[i];
            }
        }
        for(int i=0; i<n; i++) {
            arr[i]=temp[i];
        }
    }

    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []niza = new int[n];
        for(int i = 0; i < n; i++) {
            niza[i]= sc.nextInt();
        }

        pushZerosToBeginning(niza,n);
        System.out.println("Transformiranata niza e:");
        for(int i = 0; i < niza.length; i++) {
            System.out.print(niza[i]+" ");
        }
    }
}
