import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] map;
	static int[] dr = {1, 0};
	static int[] dc = {0, 1};
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map	= new int[N][M];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N][M];
		sb.append(dfs(0, 0)? 1 : 0);
		
		System.out.println(sb);
	}
	
	public static boolean dfs (int r, int c) {
		if(r==N-1 && c==M-1) return true;
	
		visited[r][c] = true;
		
		for(int i=0; i<2; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc] ==1) {
				if(!visited[nr][nc]) {
					if(dfs(nr, nc)) return true;
				}
			}
		}
		
		return false;
	}
}
