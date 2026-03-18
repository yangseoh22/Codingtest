import java.util.*;
import java.io.*;

public class Main {
	static int N, size, boomCnt;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N][N];
		boomCnt = 0;
		size = 1;
		int maxSize = 0;
		// 터지는 블럭 수, 가장 큰 블럭 크기
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(!visited[r][c]) {
					size = 1;
					dfs(r, c, map[r][c]);
					if(size>=4) boomCnt++;
					maxSize = Math.max(size, maxSize);
				}
			}
		}
		
		sb.append(boomCnt).append(" ").append(maxSize);
		System.out.println(sb);
	}
	private static void dfs(int r, int c, int now) {
		visited[r][c] = true;
		
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr>=0 && nc>=0 && nr<N && nc<N) {
				if(!visited[nr][nc] && map[nr][nc] == now) {
					size++;
					dfs(nr, nc, now);
				}
			}
		}
	}

}
