import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printNum(n);
        System.out.println();
        printReverseNum(n);
    }

    public static void printNum(int n){
        if(n==0) return;

        printNum(n-1);

        System.out.print(n + " ");
    }

    public static void printReverseNum(int n){
        if(n==0) return;

        System.out.print(n + " ");
        
        printReverseNum(n-1);
    }
}