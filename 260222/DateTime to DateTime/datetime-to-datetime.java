import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        // Please write your code here.
        int standard = 11*60*24 + 11*60 + 11;
        int day = A*60*24 + B*60 + C;

        if(day>=standard){
            System.out.println(day - standard);
        }
        else{
            System.out.println(-1);
        }
    }
}