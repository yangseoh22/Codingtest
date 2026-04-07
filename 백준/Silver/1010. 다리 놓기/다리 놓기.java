import java.util.*;
import java.io.*;

public class Main {
	static int[][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int i=0; i<TC; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			dp = new int[31][31];
			
			// M개 중에 N개를 선택하면, 서쪽에서 순서대로 이으면 됨
			int result = comb(M, N);
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

	private static int comb(int n, int r) {
		if(dp[n][r] != 0) return dp[n][r];
		
		// nC0 = nCn = 1
		if(r == 0 || n == r ) return dp[n][r] = 1;
		
		// 파스칼의 삼각형
		dp[n][r] = comb(n-1, r-1) + comb(n-1, r);
		
		return dp[n][r];
	}

}
