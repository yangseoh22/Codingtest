import java.util.Scanner;
public class Main {
    static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        cnt = 0;
        solve(n);
        System.out.println(cnt);
	}

	private static int solve(int n) {
		if(n==1) {
			return 1;
		}
		cnt++;
		if(n%2==0) {
			return solve(n/2);
		}
		else {
			return solve(n/3);
		}
	}
}