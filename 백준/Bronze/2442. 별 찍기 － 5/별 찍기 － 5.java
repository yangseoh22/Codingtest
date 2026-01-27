import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=n; i++) {  // 1부터 n번째 줄까지
			
			// 공백 n-i개
			for(int j=0; j<n-i; j++) {
				System.out.print(" ");
			}
			
			// 별 2*(i-1) + 1개
			for(int k=0; k<(2*(i-1)+1); k++)
			{
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
}