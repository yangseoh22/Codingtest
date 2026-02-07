import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int m = sc.nextInt();
	    
	    int result = lcm(n, m, gcd(n, m));
	    System.out.println(result);
	}

	private static int lcm(int n, int m, int gcd) {
		return n * m / gcd;
	}

	private static int gcd(int n, int m) {
		int s = n>m ? m : n;
		for(int i=s; i>0; i--) {
			if(n%i==0 && m%i==0) return i;
		}
		
		return 0;
	}
	
}