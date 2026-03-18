import java.io.*;
import java.util.*;

public class Main {
	static int N, M, cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for(int r = 0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c<M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		// K가 1~100일 때 안전 영역의 개수
		int maxCnt = Integer.MIN_VALUE;
		int maxK = 0;
		for(int k=1; k<=100; k++) {
			visited = new boolean[N][M];
			cnt = 0;
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					if(!visited[r][c] && map[r][c]>k) {
						cnt++;
						dfs(r, c, k);
					}
				}
			}
			if(maxCnt<cnt) {
				maxCnt = cnt;
				maxK = k;
			}
		}
		sb.append(maxK).append(" ").append(maxCnt);
		System.out.println(sb);
	}
	private static void dfs(int r, int c, int k) {
		
		visited[r][c] = true;
		
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr>=0 && nc>=0 && nr<N && nc<M) {
				if(!visited[nr][nc] && map[nr][nc]>k) {
					dfs(nr, nc, k);
				}
			}
		}
	}

}
