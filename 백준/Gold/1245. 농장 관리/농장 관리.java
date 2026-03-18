/*
 * 시간 : 124ms
 * 메모리 : 12,736kb
 * 전략 : dfs
 * 1.
 */

import java.io.*;
import java.util.*;

public class Main {
	static int N, M, maxH, cnt, newX, newY;
	static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
	static int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		maxH = Integer.MIN_VALUE;
		int startR = 0;
		int startC = 0;
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
//				if(maxH < map[r][c]) {
//					maxH = map[r][c];
//					startR = r;
//					startC = c;
//				}
			}
		}
		
		visited = new boolean[N][M];
		
		cnt = 0;

//		cnt++;
//		dfs(startR, startC, map[startR][startC]);

		while(true) {
			newX = -1;
			newY = -1;
			
			findMax();

			if(newX==-1 || newY==-1) break;
			
			cnt++;
			dfs(newX, newY, map[newX][newY]);
				
		}
		
		System.out.println(cnt);
	}
	
	private static void findMax() {
		int max = Integer.MIN_VALUE;
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(!visited[r][c] && max<map[r][c]) {
					max = map[r][c];
					newX = r;
					newY = c;
				}
			}
		}
	}

	public static void dfs(int x, int y, int prev) {
		
		visited[x][y] = true;
		
		for(int i=0; i<8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0 && ny>=0 && nx<N && ny<M) {
				if(!visited[nx][ny]) {
					if(prev>=map[nx][ny]) {
						visited[nx][ny] = true;
						dfs(nx, ny, map[nx][ny]);
					}
				}
			}
		}
	}
}
