import java.util.*;
import java.io.*;

public class Main {
	// 하, 우 이동
	static int[] dr = { 1, 0 };
	static int[] dc = { 0, 1 };
	static int N, M;
	static int[][] map;
	static boolean[][] V;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		V = new boolean[N][M];
		V[0][0] = true;

		if(DFS(0, 0)) sb.append(1).append("\n");
		else sb.append(0).append("\n");
		
		System.out.println(sb);
	}
	
	private static boolean DFS(int x, int y) {
		if(x==N-1 && y==M-1) return true;
		for (int i = 0; i < 2; i++) {
			int nx = x + dr[i];
			int ny = y + dc[i];
			
			if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
				if (map[nx][ny] == 1 && !V[nx][ny]) {
					V[nx][ny] = true;
					if(DFS(nx, ny)) return true;
				}
			}
		}
		return false;
	}
}
