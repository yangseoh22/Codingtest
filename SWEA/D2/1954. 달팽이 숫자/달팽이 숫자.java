import java.util.*;
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
			int now = 1;
			int x = 0;
			int y = 0;
			
			while(true) {
				// 다 채웠으면 종료 및 출력
				if(isFinish(map)) {
					for(int r=0; r<N; r++) {
						for(int c=0; c<N; c++) {
							sb.append(map[r][c]).append(" ");
						}
						sb.append("\n");
					}
					break;
				}
				
				// 범위 내이며 빈칸이면 숫자 채우기
				if(isRange(x, y) && map[x][y] == 0) {
					map[x][y] = now;
					
					now++;
					x += dx[dir];
					y += dy[dir];
				} else {  // 범위를 벗어났다면 회전 후 채우기
					// 이전 좌표에서 회전한 좌표 계산
					x -= dx[dir];
					y -= dy[dir];
					
					dir = (dir + 1) % 4;
					x += dx[dir];
					y += dy[dir];
				}
			}
		}
		System.out.println(sb);
	}

	// 숫자가 다 채워졌는가
	private static boolean isFinish(int[][] map) {
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c] == 0) return false;
			}
		}
		
		return true;
	}
	
	// 맵 범위 내의 좌표인가
	private static boolean isRange(int nx, int ny) {
		if(nx < 0 || ny < 0 || nx >= N || ny >= N) return false;
		
		return true;
	}

	

}
