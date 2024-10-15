import java.util.Scanner;

public class ReverseWord {

    public static void printReversed(String word) {
        StringBuilder reversed = new StringBuilder(word);
        reversed.reverse();
        System.out.println(reversed);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String []word = new String[n];
        for(int i = 0; i < n; i++) {
            word[i] = sc.next();
        }
        for(int i = 0; i < n; i++) {
            printReversed(word[i]);
        }
    }
}
