import java.io.*;
import java.util.Arrays;

public class Main {
	static int[] dp;
	static int minCnt = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		dp = new int[n+1];
		Arrays.fill(dp, -1);
		
		int result = solve(n, 0);
		
		System.out.println(result==Integer.MAX_VALUE?-1:result);
	}

	private static int solve(int n, int c) {
		if(dp[n] != -1) return dp[n];
				
		if(n<=1) {
			if(n==0) {
				minCnt = Math.min(minCnt, c);
			}
			dp[n] = 0;
		}
		else if(n==4 || n==3 || n==2) {
			dp[n] = solve(n-2, c+1);
		}
		else {
			dp[n] = solve(n-5, c+1) + solve(n-2, c+1);
		}
		
		return minCnt;
	}

}
