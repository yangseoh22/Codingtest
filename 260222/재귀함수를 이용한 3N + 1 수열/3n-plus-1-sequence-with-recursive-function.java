import java.util.Scanner;
public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int cnt = solve(n);
        
        System.out.println(cnt);
	}
	private static int solve(int n) {
		if(n==1) return 0;

		if(n%2==0) return solve(n/2) + 1;
		else return solve(n*3 + 1) + 1;
	}
}