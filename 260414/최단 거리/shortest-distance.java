import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] adj = new int[N][N];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				adj[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 플로이드 워셜로 최단 경로 구하기
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
				}
			}
		}
		
		// M개의 질의
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			// 위에서 인덱스 기준으로 진행했으므로 장소 번호 -1
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			
			sb.append(adj[from][to]).append("\n");
		}
		
		System.out.println(sb);
	}

}
