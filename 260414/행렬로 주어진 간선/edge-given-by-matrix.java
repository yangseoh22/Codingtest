import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[][] adj = new int[N][N];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				adj[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 자기 자신으로 가는 것은 연결 가능
		for(int i=0; i<N; i++) {
			adj[i][i] = 1;
		}
		
		// 다른 정점을 지나가 연결 될 수 있는지 확인
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(adj[i][k] == 1 &&  adj[k][j] == 1) {
						adj[i][j] = 1;
					}
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(adj[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
