import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=TC; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[] weight = new int[N+1];
			int[] value = new int[N+1];
			
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				 weight[i] = Integer.parseInt(st.nextToken());
				 value[i] = Integer.parseInt(st.nextToken());
			}
			
			int[][] dp = new int[N + 1][K + 1];
			for (int i = 1; i <= N; i++) { // 물건 하나씩 확인
			    for (int w = 1; w <= K; w++) { // 가방 용량 1부터 증가
			        if (weight[i] <= w) {
			            // 담는 경우 vs 안 담는 경우 중 최댓값
			            dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weight[i]] + value[i]);
			        } else {
			            // 무거워서 못 담으면 이전 물건의 결과 그대로 사용
			            dp[i][w] = dp[i - 1][w];
			        }
			    }
			}
			
			sb.append("#").append(t).append(" ").append(dp[N][K]).append("\n");
		}
		System.out.println(sb);
	}

}
