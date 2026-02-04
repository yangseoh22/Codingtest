import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] map = new int[100][100];

	// (도착점 -> 시작점) 사다리는 올라가거나 좌 우로 이동만 가능
	static int[] dr = { 0, 0, -1 };
	static int[] dc = { -1, 1, 0 };

	static boolean[][] visited = new boolean[100][100];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int TC = 10;

		for (int t = 0; t < TC; t++) {

			// 테스트 케이스 번호
			int test_case = Integer.parseInt(br.readLine());
			sb.append("#").append(test_case).append(" ");

			int startX = 0;
			int goalX = 0;
			int goalY = 0;
			visited = new boolean[100][100];
			
			// 사다리 입력
			for (int r = 0; r < 100; r++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < 100; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					
					// 도착점 확인
					if (map[r][c] == 2) {
						visited[r][c] = true;
						goalX = r;
						goalY = c;
					}
				}
			}

			// DFS 실행
			sb.append(DFS(goalX, goalY)).append("\n");
		}
		System.out.println(sb);
	}

	public static int DFS(int r, int c) {
		// 0행에 도착했으면 종료
		if (r == 0)
			return c;
		
		// 3방향 탐색 (좌/우 -> 상 순으로 확인)
		for (int i = 0; i < 3; i++) {
			int newR = r + dr[i];
			int newC = c + dc[i];
			
			// 범위 유효 체크
			if (newR >= 0 && newR < 100 && newC >= 0 && newC < 100) {
				// 1이고, 방문하지 않았던 곳이라면
				if (map[newR][newC] == 1 && !visited[newR][newC]) {
					visited[newR][newC] = true; // 방문 체크
					return DFS(newR, newC); // 재귀 호출
				}
			}
		}
		
		return 0;
	}
}
