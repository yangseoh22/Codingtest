import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] visited;
	static int N, cnt;
	
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		int maxH = Integer.MIN_VALUE;
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				maxH = Math.max(maxH, map[r][c]);
			}
		}
		
		int maxCnt = 0;
		for(int i = 0; i<maxH; i++) {
			int rain = i;
			visited = new boolean[N][N];  // 잠긴 곳을 방문표시
			cnt = 0;
			
			// 잠긴 곳 찾기
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(map[r][c]<=rain) visited[r][c] = true;
				}
			}

			// 안전 영역 찾기
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					// 잠기지 않은 곳을 찾으면 BFS
					if(!visited[r][c]) {
						cnt++;
						BFS(r, c, visited);
					}
				}
			}
			
			maxCnt = Math.max(maxCnt, cnt);
		}
		
		System.out.println(maxCnt);
	}
	
	private static void BFS(int r, int c, boolean[][] visited) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r, c});
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			int now[] = q.poll();
			
			// 4방 탐색으로 인접 영역 확인
			for(int i=0; i<4; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];
				
				if(nr>=0 && nr<N && nc>=0 && nc<N) {
					if(!visited[nr][nc]) {
						q.add(new int[] {nr, nc});
						visited[nr][nc] = true;
					}
				}
			}
		}
		
	}

}
