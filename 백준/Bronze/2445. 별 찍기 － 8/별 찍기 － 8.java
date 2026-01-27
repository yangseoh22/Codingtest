import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
	
		for (int i = 1; i <= n; i++) { // 1부터 n번째 줄까지

			// * i개
			for (int j = 0; j<i; j++) {
				System.out.print("*");
			}

			// 별 2*n-2*i개
			for (int k = 0; k < 2*n-2*i; k++) {
				System.out.print(" ");
			}
			
			// * i개
			for (int j = 0; j <i; j++) {
				System.out.print("*");
			}

			System.out.println();
		}
		
		for (int i=n-1; i > 0; i--) { // n-1번째 부터 1번째까지

			// * i개
			for (int j = 0; j<i; j++) {
				System.out.print("*");
			}

			// 별 2*n-2*i개
			for (int k = 0; k < 2*n-2*i; k++) {
				System.out.print(" ");
			}
			
			// * i개
			for (int j = 0; j <i; j++) {
				System.out.print("*");
			}

			System.out.println();
		}
	}
}
