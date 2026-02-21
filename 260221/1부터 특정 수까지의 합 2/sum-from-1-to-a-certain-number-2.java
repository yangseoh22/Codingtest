import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int result = sum(n);
        System.out.println(result);
	}

	private static int sum(int n) {
		if(n==1) return 1;
		
		return sum(n-1) + n;
	}
}