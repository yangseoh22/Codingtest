import java.util.*;
import java.io.*;

public class Main {
	static int N, startX, startY, goalX, goalY;
	static int[][] map;
	static int[][] visited;
	static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dy = {-2, -1, 1, 2, -2, -1, 1, 2};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			st = new StringTokenizer(br.readLine());
			startX = Integer.parseInt(st.nextToken());
			startY = Integer.parseInt(st.nextToken());
		
			st = new StringTokenizer(br.readLine());
			goalX = Integer.parseInt(st.nextToken());
			goalY = Integer.parseInt(st.nextToken());
			
			visited = new int[N][N];
			for(int i=0; i<N; i++) {
				Arrays.fill(visited[i], -1);  // 방문하기 전 -1 초기화
			}
			
			BFS(startX, startY);
			
			int min = visited[goalX][goalY];
			
			sb.append(min).append("\n");
		}
		System.out.println(sb);
	}

	private static void BFS(int sx, int sy) {
		Queue<int[]> q = new LinkedList<>();
		visited[sx][sy] = 0;
		q.offer(new int[] {sx, sy});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];

			if(x==goalX && y==goalY) break;
			
			for(int i=0; i<8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx>=0 && nx<N && ny>=0 && ny<N) {
					if(visited[nx][ny] == -1) {
						visited[nx][ny] = visited[x][y] + 1;
						q.offer(new int[] {nx, ny});
					}
				}
			}
		}
	
	}

}
