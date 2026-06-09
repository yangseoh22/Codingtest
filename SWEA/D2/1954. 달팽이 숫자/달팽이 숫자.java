import java.io.*;

public class Solution {
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for(int t=1; t<=TC; t++) {
			sb.append("#").append(t).append("\n");

			N = Integer.parseInt(br.readLine());
			
			int[][] map = new int[N][N];
			int dir = 0;
			int x = 0;
			int y = 0;
			
			for(int n=1; n<=N*N; n++) {
				map[x][y] = n;
				
				// 다음 좌표 계산
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				
				// 범위 내가 아니거나 이미 채워져 있으면
				if(!isRange(nx, ny) || map[nx][ny] != 0) {
					// 회전
					dir = (dir+1) % 4;
					nx = x + dx[dir];
					ny = y + dy[dir];
				}
				
				// 좌표 갱신
				x = nx;
				y = ny;
			}
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					sb.append(map[r][c]).append(" ");
				}
				sb.append("\n");
			}
			
		}
		System.out.println(sb);
	}
	
	// 맵 범위 내의 좌표인가
	private static boolean isRange(int nx, int ny) {
		if(nx < 0 || ny < 0 || nx >= N || ny >= N) return false;
		
		return true;
	}
}
