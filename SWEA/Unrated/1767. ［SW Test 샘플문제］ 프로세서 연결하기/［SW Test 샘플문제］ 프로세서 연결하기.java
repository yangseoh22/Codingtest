import java.io.*;
import java.util.*;

public class Solution {
	static int[][] map;
	static ArrayList<int[]> cores;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N, maxCore, minWire;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			N = Integer.parseInt(br.readLine());
			maxCore = 0;
			minWire = Integer.MAX_VALUE;
			
			map = new int[N][N];
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			cores = new ArrayList<>();
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (r == 0 || c == 0 || r == N-1 || c == N-1)  // 가장자리는 무시
						continue;
					if(map[r][c] == 1)
						cores.add(new int[] { r, c }); // 코어 좌표 저장
				}
			}

			DFS(0, 0, 0);
			sb.append("#").append(t).append(" ").append(minWire).append("\n");
		}
		System.out.println(sb);
	}

	private static void DFS(int idx, int coreCnt, int wireLen) {
		// 기저 : 모든 코어를 확인
		if (idx == cores.size()) {
			if (coreCnt > maxCore) { // 최대 코어를 연결했으면, 코어 수와 와이어 길이 갱신
				maxCore = coreCnt;
				minWire = wireLen;
			} else if (coreCnt == maxCore) { // 현재 최대 코어와 같다면, 와이어 길이만 갱신
				minWire = Math.min(minWire, wireLen);
			}
			return;
		}

		int[] nowCore = cores.get(idx);
		int r = nowCore[0];
		int c = nowCore[1];
		
		// 1. 코어의 4방향에 전선 놓기
		for (int d = 0; d < 4; d++) {
			if (canConnect(r, c, d)) {
				// 갈 수 있으면 전선 깔기
				int len = setWire(r, c, d, 2);  // 깐 전선 개수

				// 다음 코어로 이동
				DFS(idx + 1, coreCnt + 1, wireLen + len);

				// 백트래킹 : 전선 지우기
				setWire(r, c, d, 0);
			}
		}
		
		// 2. 코어를 연결하지 않고 넘어가는 경우
		DFS(idx + 1, coreCnt, wireLen);
	}

	public static boolean canConnect(int r, int c, int dir) {
		int nr = r + dr[dir];
		int nc = c + dc[dir];

		// 범위 내, 막힌 곳이 없는지 확인
		while (nr >= 0 && nc >= 0 && nr < N && nc < N) {
			if (map[nr][nc] != 0)
				return false;
			nr += dr[dir];
			nc += dc[dir];
		}
		return true;
	}

	private static int setWire(int r, int c, int dir, int val) {
		int cnt = 0;
		int nr = r + dr[dir];
		int nc = c + dc[dir];

		while (nr >= 0 && nc >= 0 && nr < N && nc < N) {
			map[nr][nc] = val;
			cnt++;
			nr += dr[dir];
			nc += dc[dir];
		}
		return cnt;
	}
}
