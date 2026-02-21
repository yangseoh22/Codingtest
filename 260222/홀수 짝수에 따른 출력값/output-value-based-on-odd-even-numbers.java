import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int result = fact(n);
        System.out.println(result);
	}

	private static int fact(int n) {
		if(n==1) return 1;
		else if(n==2) return 2;
		
		return fact(n-2) + n;
	}
}