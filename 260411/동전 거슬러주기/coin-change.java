import java.util.*;
import java.io.*;

public class Main{

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] coin = new int[N+1];
		int[] dp = new int[M+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			coin[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = 0;
		for(int i=1; i<=M; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		
		for(int i=1; i<=M; i++) {
			for(int j=1; j<=N; j++) {
				if(i>=coin[j]) {
					if(dp[i-coin[j]] == Integer.MAX_VALUE) continue;
					
					dp[i] = Math.min(dp[i], dp[i-coin[j]] + 1);
				}
			}
		}
		
		System.out.println(dp[M]==Integer.MAX_VALUE? -1 : dp[M]);
	}

}
