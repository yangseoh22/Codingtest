import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] adj = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			Arrays.fill(adj[i], 100001);
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			// 중복으로 들어올 수 있으므로 -> 더 작은 값 채택
			adj[start][end] = Math.min(weight, adj[start][end]);  // 방향 그래프 -> 행렬
        }
		
		for(int i=1; i<=N; i++) {
			adj[i][i] = 0;
		}
		
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
				}
			}
		}
		
		for(int r=1; r<=N; r++) {
			for(int c=1; c<=N; c++) {
				if(adj[r][c]==100001) sb.append(-1).append(" ");
				else sb.append(adj[r][c]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
