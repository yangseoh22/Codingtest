import java.io.*;
import java.util.Arrays;

public class Main {
	static int[] memo;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		memo = new int[N+1];
		Arrays.fill(memo, -1);
		System.out.println(fillReg(N));
	}

	private static int fillReg(int n) {
		if(memo[n] != -1)  return memo[n];
		
		if(n<=2) {
			if(n==1) return 1;
			else if(n==2) return 2;
		}
		else {
			memo[n] = fillReg(n-1) + fillReg(n-2);
		}
		return memo[n] % 10007;
	}
	
}
