import java.util.*;
import java.io.*;

public class Main {
	static int[][][] box;
	static int H, N, M, cnt;
	// 위, 아래, 왼쪽, 오른쪽, 앞, 뒤
	static int[] dh = { 1, -1, 0, 0, 0, 0 };
	static int[] dr = { 0, 0, 0, 0, 1, -1 };
	static int[] dc = { 0, 0, -1, 1, 0, 0 };

	static Queue<int[]> q;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		cnt = 0;
		
		q = new LinkedList<>();
		box = new int[H][N][M];

		boolean flag = false;
		// 토마토 상태 입력
		for (int h = 0; h < H; h++) {
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < M; c++) {
					box[h][r][c] = Integer.parseInt(st.nextToken());
					
					// 익은 토마토 큐에 넣기
					if(box[h][r][c]==1) {
						q.add(new int[] {h, r, c});
					}
					
					if(box[h][r][c]==0) flag = true;  // 익지 않은게 존재
				}
			}
		}
		
		boolean isTomato = true;
		// 입력때부터 이미 모두 익어있는 경우
		if(!flag) sb.append(0);
		else{
			BFS();
			
			for (int h = 0; h < H; h++) {
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < M; c++) {
						// 익히지 못한 것이 존재
						if(box[h][r][c]==0) {
							isTomato = false;
							break;
						}
					}
					if(!isTomato) break;
				}
				if(!isTomato) break;
			}
			if(isTomato) sb.append(cnt);  // 걸린 날짜 출력
			else sb.append(-1);  // 다 익히지 못했을 때
		}
		

		System.out.println(sb);
	}

	private static void BFS() {
		while (!q.isEmpty()) {
			int size = q.size();  // 초기 1의 개수
			boolean day = false;

			for(int t=0; t<size; t++) {  // 큐에 들어온 것들을 꺼내 순회
				int now[] = q.poll();

				for (int i = 0; i < 6; i++) {
					int nh = now[0] + dh[i];
					int nr = now[1] + dr[i];
					int nc = now[2] + dc[i];

					// 인접 토마토가 익지 않은 것이라면 익음으로 변경
					if (isRange(nh, nr, nc) && box[nh][nr][nc] == 0) {
						box[nh][nr][nc] = 1;
						q.add(new int[] { nh, nr, nc });
						day = true;
					}
				}
			}
			if(day) cnt++;  // 6방 탐색 후에도 큐가 비어있지 않다면 증가
		}
	}
	
	// 범위 유효성 체크
	private static boolean isRange(int nh, int nr, int nc) {
		if (nh >= 0 && nr >= 0 && nc >= 0 && nh < H && nr < N && nc < M) {
			return true;
		}

		return false;
	}

}
