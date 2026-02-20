import java.io.*;
import java.util.*;

public class Solution {
	static int[][] map;
	static int startX, startY, goalX, goalY;
	static boolean[][] visited;
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = 10;

		for (int t = 1; t <= TC; t++) {
			int tc = Integer.parseInt(br.readLine());
			
			map = new int[100][100];
			
			// 지도 입력
			for(int r=0; r<100; r++) {
				String tmp = br.readLine();
				for(int c=0; c<100; c++) {
					map[r][c] = tmp.charAt(c) - '0';
					if(map[r][c]==2) {
						startX = r;
						startY = c;
					}
					if(map[r][c]==3) {
						goalX = r;
						goalY = c;
					}
				}
			}
			
			int result = BFS(startX, startY)? 1 : 0;
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
	}
	private static boolean BFS(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		visited = new boolean[100][100];
		
		q.add(new int[] {x, y});
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			// 목표점에 도달했는가?
			if(now[0]==goalX && now[1]==goalY) {
				return true;
			}
			
			for(int i=0; i<4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				
				if(nx>=0 && nx<100 && ny>=0 && nx<100) {
					if(map[nx][ny]!=1 && !visited[nx][ny]) {
						visited[nx][ny] = true;
						q.add(new int[] {nx, ny});
					}
				}
			}
		}
		
		return false;
	}
}
