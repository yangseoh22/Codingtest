import java.util.*;
import java.io.*;

public class Solution {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int N, K;
	static int[][] map;
	static boolean[][] visited;
	static int maxLen;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			int maxH = Integer.MIN_VALUE;
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					maxH = Math.max(maxH, map[r][c]);
				}
			}

			// 봉우리 좌표 저장
            maxLen = Integer.MIN_VALUE;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] == maxH) {
						visited = new boolean[N][N];
						DFS(r, c, 1, false);  // 무조건 길이는 1부터
					}
				}
			}

			sb.append("#").append(t).append(" ").append(maxLen).append("\n");
		}
		System.out.println(sb);
	}

	private static void DFS(int x, int y, int len, boolean usedK) {
		maxLen = Math.max(maxLen, len);

		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dr[i];
			int ny = y + dc[i];

			if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
				if (map[nx][ny] < map[x][y]) {
					// 그냥 갈 때
					DFS(nx, ny, len + 1, usedK);
				}
				// 아직 깎찌 않았고, 깎아서 갈 때
				else if(!usedK && map[nx][ny] - K < map[x][y]) {	
					int origin = map[nx][ny];  // 원복을 위해 저장
					map[nx][ny] = map[x][y] - 1;  // 1만 깎아야 좋음
					DFS(nx, ny, len + 1, true);
					map[nx][ny] = origin;  // 백트래킹
				}
			}

		}
		
		visited[x][y] = false;
	}
}
