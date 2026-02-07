import java.util.Scanner;
public class Main {
   public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    
	    rect(n);
	}

	private static void rect(int n) {
		int num = 1;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(num>9) num = 1;
				System.out.print(num++ + " ");
			}
			System.out.println();
		}
	}
}