import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        int b = sc.nextInt();

        int cnt = 0;
        for(int i=a; i<=b; i++){
            if(onjeon(i)) cnt++;
        }

        System.out.println(cnt);
    }

    public static boolean onjeon(int x){
        if(x%2==0) return false;
        if(x%10==5) return false;
        if(x%3==0 && x%9!=0) return false;

        return true;
    }
}