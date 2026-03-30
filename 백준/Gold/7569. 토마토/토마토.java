import java.util.*;
import java.io.*;

public class Main {
	static int M, N, H;
	static int cnt = 0;
	static Queue<int[]> q;
	static int[][][] box;
	static boolean[][][] visited;
	// 위, 아래, (2차원상의)상, 하, 좌, 우
	static int[] dh = { 1, -1, 0, 0, 0, 0 };
	static int[] dr = { 0, 0, -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		box = new int[H][N][M];
		visited = new boolean[H][N][M];
		boolean isAllOne = true; // 이미 모두 익어있음
		q = new LinkedList<>();
		for (int h = 0; h < H; h++) {
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < M; c++) {
					box[h][r][c] = Integer.parseInt(st.nextToken());
					if (box[h][r][c] == 0)
						isAllOne = false;
					else if(box[h][r][c] == 1)
						q.add(new int[]{h, r, c, 0});
				}
			}
		}

		BFS(0, 0, 0);

		if (isAllOne)
			System.out.println(0);
		else {
			// 익지 않은 것이 존재
			if (!isAll())
				System.out.println(-1);
			// 모두 익음
			else
				System.out.println(cnt);
		}

	}

	// 모두 익었는가
	private static boolean isAll() {
		for (int h = 0; h < H; h++) {
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (box[h][r][c] == 0)
						return false;
				}
			}
		}
		// -1이나 1만 있으면 모두 잘 익은 것
		return true;
	}

	// 인접 토마토 익히기
	private static void BFS(int h, int r, int c) {

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int nh = now[0];
			int nr = now[1];
			int nc = now[2];
			int nowDay = now[3];
			cnt = nowDay;
			
			for (int i = 0; i < 6; i++) {
				int newh = nh + dh[i];
				int newr = nr + dr[i];
				int newc = nc + dc[i];

				// 범위 내이고 0이라면 익히기
				if (newh >= 0 && newr >= 0 && newc >= 0 && newh < H && newr < N && newc < M) {
					if (box[newh][newr][newc] == 0) {  //안익은거라면
						box[newh][newr][newc] = 1; // 익히기
						q.add(new int[] {newh, newr, newc, nowDay+1});
					}
				}
			}
		}
	}

}
