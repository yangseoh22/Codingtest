import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int r = solve(n);
        
        System.out.println(r);
	}
	private static int solve(int n) {
		if(n<1) return 0;
		if(n==1) return 1;
		if(n==2) return 2;
		
		return solve((int)Math.floor(n/3)) + solve(n-1);
	}
}