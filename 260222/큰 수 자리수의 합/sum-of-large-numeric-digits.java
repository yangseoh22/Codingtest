import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        
        int result = solve(a, b, c);
        
        System.out.println(result);
	}
	private static int solve(int a, int b, int c) {
		int n = a * b * c;
		
		int sum = 0;
		while(n>=10) {
			sum += n % 10;
			n = n/10;
		}
		sum += n;
		
		return sum;
	}
}