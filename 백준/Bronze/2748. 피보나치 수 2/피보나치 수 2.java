import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n= sc.nextInt();
		
		long prev=0;
		long now=1;
		long fibo=0;
		
		if(n==0) fibo = 0;
		else if (n==1) fibo = 1;
		else {
			for(int i=2; i<=n; i++) {
				fibo = prev+now;
				prev = now;
				now = fibo;
			}
		}
	
		System.out.println(fibo);
	}
}