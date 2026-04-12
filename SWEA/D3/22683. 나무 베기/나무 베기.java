import java.util.*;
import java.io.*;

public class Solution {
	static int[][] map;
	static int N, K, carX, carY, result;
	static boolean[][][][] visited;
	// 상(0), 우(1), 하(2), 좌(3)
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			for (int r = 0; r < N; r++) {
				String lines = br.readLine();
				for (int c = 0; c < N; c++) {
					map[r][c] = lines.charAt(c);
					if (map[r][c] == 'X') { // 현재 위치
						carX = r;
						carY = c;
					}
				}
			}

			result = -1;
			// visited[나무벤횟수][방향][x][y]
			visited = new boolean[K + 1][4][N][N];
			BFS(carX, carY);

			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

	private static void BFS(int sx, int sy) {
		Queue<Points> q = new LinkedList<>();
		visited[0][0][sx][sy] = true;
		q.add(new Points(sx, sy, 0, 0, 0));

		while (!q.isEmpty()) {
			Points now = q.poll();

			if (map[now.x][now.y] == 'Y') {
				result = now.moveCnt;
				return;
			}

			// ------ 전진 -----
			int nx = now.x + dr[now.dir];
			int ny = now.y + dc[now.dir];

			if (nx >= 0 && ny >= 0 && nx < N && ny < N) {

				// 나무를 자르지 않는 경우
				if (map[nx][ny] == 'G' || map[nx][ny] == 'Y' || map[nx][ny] == 'X') {
					if (!visited[now.kCnt][now.dir][nx][ny]) {
						visited[now.kCnt][now.dir][nx][ny] = true;
						q.add(new Points(nx, ny, now.dir, now.kCnt, now.moveCnt + 1));
					}
				}
				// 나무를 자르는 경우
				else if (map[nx][ny] == 'T' && now.kCnt < K) {
					if (!visited[now.kCnt + 1][now.dir][nx][ny]) {
						visited[now.kCnt + 1][now.dir][nx][ny] = true;
						q.add(new Points(nx, ny, now.dir, now.kCnt + 1, now.moveCnt + 1));
					}
				}
			}
			
			// --- 자회전 ---
			int left = (now.dir - 1 + 4) % 4;
			if (!visited[now.kCnt][left][now.x][now.y]) {
				visited[now.kCnt][left][now.x][now.y] = true;
				q.add(new Points(now.x, now.y, left, now.kCnt, now.moveCnt + 1));
			}

			// --- 우회전 ---
			int right = (now.dir + 1) % 4;
			if (!visited[now.kCnt][right][now.x][now.y]) {
				visited[now.kCnt][right][now.x][now.y] = true;
				q.add(new Points(now.x, now.y, right, now.kCnt, now.moveCnt + 1));
			}

		}
	}

	private static class Points {
		int x, y, dir, kCnt, moveCnt;

		public Points(int x, int y, int dir, int kCnt, int moveCnt) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.kCnt = kCnt;
			this.moveCnt = moveCnt;
		}
	}
}
