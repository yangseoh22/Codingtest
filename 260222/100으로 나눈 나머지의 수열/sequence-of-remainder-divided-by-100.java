import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int r = solve(n);
        
        System.out.println(r);
	}
	private static int solve(int n) {
		if(n<=2) {
			if(n==1) return 2;
			if(n==2) return 4;
		}
		
		return solve(n-1) * solve(n-2) % 100;
	}

}