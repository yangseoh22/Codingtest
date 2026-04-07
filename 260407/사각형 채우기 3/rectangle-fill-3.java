import java.io.*;
import java.util.Arrays;

public class Main {
	static long[] memo;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		memo = new long[N+1];
		Arrays.fill(memo, -1);
		
		System.out.println(solve(N));
	}
	private static int solve(int n) {
		if(n==0) memo[n] = 0;
		else if(n==1) memo[n] = 2;
		
		if(memo[n] != -1) return memo[n];
		
		return memo[n] = (solve(n-1)*3+1) % 1000000007L;
	}

}
