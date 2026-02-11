import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        // Please write your code here.
        System.out.println(solve(a, b));
    }

    public static int solve (int a, int b){
        int cnt = 0;
        for(int i=a; i<=b; i++){
            if(isPrime(i)){
                if(isEven(i)) cnt++;
            }
        }
        return cnt;
    }

    public static boolean isPrime(int n){
        if (n==1) return false;
        for(int i=2; i<n; i++){
            if(n%i==0) return false;
        }

        return true;
    }

    public static boolean isEven(int n){
        int sum = 0;
        while(n>0){
            sum += n%10;
            n = n/10;
        }
        if(sum%2==0) return true;
        else return false;
    }
}