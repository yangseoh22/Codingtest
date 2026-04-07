import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int K = Integer.parseInt(br.readLine());
		int[][] dp = new int[2][K+1];
		Arrays.fill(dp[0], -1);
		Arrays.fill(dp[1], -1);
		
		dp[0][0] = 1;
		dp[1][0] = 0;
		dp[0][1] = 0;
		dp[1][1] = 1;
		
		for(int i=2; i<=K; i++) {
			if(dp[0][i] != -1 && dp[1][i] != -1) continue;
			
			dp[0][i] = dp[0][i-1]+dp[0][i-2];
			dp[1][i] = dp[1][i-1]+dp[1][i-2];
		}
		
		sb.append(dp[0][K]).append(" ").append(dp[1][K]);
		System.out.println(sb);
	}

}
