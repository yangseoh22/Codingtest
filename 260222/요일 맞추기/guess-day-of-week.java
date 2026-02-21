import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        // Please write your code here.
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int a = d1;
        for(int i=0; i<m1; i++){
            a += days[i];
        }
        
        int b = d2;
        for(int i=0; i<m2; i++){
            b += days[i];
        }

        String dayAfter[] = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        String dayAgo[] = {"Mon", "Sun", "Sat", "Fri", "Thu", "Wed", "Tue"};
        
        int idx = 0;
        if(b>a) {
            idx = (b-a)%7;
            System.out.println(dayAfter[idx]);
        }
        else {
            idx = (a-b)%7;
            System.out.println(dayAgo[idx]);
        }
        
    }
}