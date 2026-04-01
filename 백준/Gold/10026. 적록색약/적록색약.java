import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int RGB, notRGB;
	static char[][] map;
	static char[][] mapV2;
	static boolean[][] visited;
	static Queue<Color> q = new LinkedList<>();

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		map = new char[N][N];
		for (int r = 0; r < N; r++) {
			String lines = br.readLine();
			for (int c = 0; c < N; c++) {
				map[r][c] = lines.charAt(c);
			}
		}

		// 일반 사람
		RGB = 0;
		visited = new boolean[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (!visited[r][c]) {
					q.add(new Color(r, c, map[r][c]));
					visited[r][c] = true;
					BFS();
					RGB++;
				}
			}
		}

		// 적록색약
		notRGB = 0;
		visited = new boolean[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (!visited[r][c]) {
					q.add(new Color(r, c, map[r][c]));
					visited[r][c] = true;
					BFS_v2();
					notRGB++;
				}
			}
		}

		sb.append(RGB).append(" ").append(notRGB);

		System.out.println(sb);
	}

	private static void BFS_v2() {
		while (!q.isEmpty()) {
			Color now = q.poll();
			char color = now.c;

			for (int i = 0; i < 4; i++) {
				int nr = now.x + dr[i];
				int nc = now.y + dc[i];

				if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc]) {
					// R과 G는 같은 것으로 보기
					if (color == 'R' || color == 'G') {
						if (map[nr][nc] == 'R' || map[nr][nc] == 'G') {
							q.add(new Color(nr, nc, color));
							visited[nr][nc] = true;
						}
					} else {
						if (map[nr][nc] == color) {
							q.add(new Color(nr, nc, color));
							visited[nr][nc] = true;
						}
					}
				}
			}
		}
	}

	private static void BFS() {
		while (!q.isEmpty()) {
			Color now = q.poll();
			char color = now.c;

			for (int i = 0; i < 4; i++) {
				int nr = now.x + dr[i];
				int nc = now.y + dc[i];

				if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
					if (!visited[nr][nc] && map[nr][nc] == color) {
						q.add(new Color(nr, nc, color));
						visited[nr][nc] = true;
					}
				}
			}
		}
	}

	public static class Color {
		int x, y;
		char c;

		public Color(int x, int y, char c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}
}
