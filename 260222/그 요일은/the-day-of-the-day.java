import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        String A = sc.next();
        
        int[] days = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int before = 0;
        for(int i=1; i<m1; i++) {
        	before += days[i];
        }
        before += d1;
        
        int after = 0;
        for(int i=1; i<m2; i++) {
        	after += days[i];
        }
        after += d2;
        
        int diff = after - before;
        System.out.println(diff/7 + 1);
	}
}