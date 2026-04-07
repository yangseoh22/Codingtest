import java.io.*;

public class Main {
	static int[] memo;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		memo = new int[N+1];
		
		System.out.println(step(N));
	}

	private static int step(int n) {
		if(n<=1) {
			if(n==0) return 1;
			return 0;
		}
		else {
			memo[n] = step(n-2) + step(n-3);
		}
		return memo[n];
	}
	
}
