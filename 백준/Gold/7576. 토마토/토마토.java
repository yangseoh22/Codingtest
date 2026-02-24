import java.util.*;
import java.io.*;

public class Main {
	static int N, M, cnt;
	static int[][] box;
	static boolean[][] V;
	static Queue<int[]> q= new LinkedList<>();
	// 위, 아래, 왼쪽, 오른쪽
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = { 0, 0, 1, -1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		cnt = 0;
		
		box = new int[N][M];
		V = new boolean[N][M];
		boolean notZero = true;
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				box[r][c] = Integer.parseInt(st.nextToken());
				
				// 0이 존재하는가
				if(box[r][c]==0) {
					notZero = false;
				}
				
				// 1인 곳을 큐에 넣기, 방문 표시
				if(box[r][c]==1) {
					q.add(new int[] {r, c});
					V[r][c] = true;
				}
			}
		}
		
		// 이미 다 익어있으면, 초기 토마토는 모두 익어있음
		if(notZero) sb.append(0);
		// 익지 않은 게 있으면, BFS 호출
		else {
			BFS();
			
			boolean flag = false;
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					// 익지 못하는 토마토 존재
					if(box[r][c]==0) {
						sb.append(-1);
						flag = true;
						break;
					}
				}
				if(flag) break;
			}
			
			// 모두 익음
			if(!flag) sb.append(cnt);
		}
		
		System.out.println(sb);
	}

	private static void BFS() {
		
		while (!q.isEmpty()) {
			int size = q.size();
			boolean flag = false;  // 오늘 토마토가 익었는가
			
			// 현재 큐에 담긴 모든 익은 토마토 순회 -> 하루
			for(int j=0; j<size; j++) {
				int now[] = q.poll();
				
				for (int i = 0; i < 4; i++) {
					int nr = now[0] + dr[i];
					int nc = now[1] + dc[i];
					
					// 유효 범위 내의 안익은 곳을 찾았으면 1으로 변경, 방문 표시
					if (isRange(nr, nc) && box[nr][nc] == 0  && !V[nr][nc]) {
						box[nr][nc] = 1;
						V[nr][nc] = true;
						q.add(new int[] {nr, nc});
						flag = true;
					}
				}
			}
			if(flag) cnt++;
		}
		
	}
	
	private static boolean isRange(int nr, int nc) {
		if (nr >= 0 && nc >= 0 && nr < N && nc < M) {
			return true;
		}

		return false;
	}
}
