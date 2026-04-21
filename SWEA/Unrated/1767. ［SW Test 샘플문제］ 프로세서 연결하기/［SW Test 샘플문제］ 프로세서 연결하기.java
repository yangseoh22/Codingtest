import java.util.*;
import java.io.*;

public class Solution {
	static int[][] map;
	static ArrayList<Points> cores;
	static int N, maxCore, minWire;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			cores = new ArrayList<>();
			maxCore = 0;
			minWire = Integer.MAX_VALUE;

			for(int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					
					if(map[r][c] == 1) {
						if(r==0 || c==0 || r==N-1 || c==N-1) {
							maxCore++;
						}
						else cores.add(new Points(r, c));
					}
				}
			}
			
			DFS(0, maxCore, 0);
			
			sb.append("#").append(t).append(" ").append(minWire).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void DFS(int idx, int coreCnt, int wireCnt) {
		if(idx == cores.size()) {
			if(maxCore < coreCnt) {
				maxCore = coreCnt;
				minWire = wireCnt;
			}
			else if(maxCore==coreCnt) {
				minWire = Math.min(minWire, wireCnt);
			}
			
			return;
		}
		
		Points now = cores.get(idx);
		
		// 1. 코어 연결
		for(int d=0; d<4; d++) {
			// 연결 가능하다면 -> 연결
			if(canConnect(now.x, now.y, d)) {
				// 1-1. 전선 깔기
				int lenCnt = setWire(now.x, now.y, d, 2);
				
				// 1-2. 다음 호출
				DFS(idx+1, coreCnt+1, wireCnt+lenCnt);
				
				// 1-3. 전선 회수
				setWire(now.x, now.y, d, 0);
			}
		}
		
		// 2. 코어 연결 안하기
		DFS(idx+1, coreCnt, wireCnt);
	}

	private static int setWire(int x, int y, int dir, int val) {
		int nx = x + dr[dir];
		int ny = y + dc[dir];
		
		int cnt = 0;  // 전선 개수
		while(nx>=0 && nx<N && ny>=0 && ny<N) {
			map[nx][ny] = val;
			cnt++;
			nx += dr[dir];
			ny += dc[dir];
		}
		
		return cnt;
	}

	private static boolean canConnect(int x, int y, int dir) {
		int nx = x + dr[dir];
		int ny = y + dc[dir];
		
		while(nx>=0 && nx<N && ny>=0 && ny<N) {
			if(map[nx][ny] != 0) return false;  // 다른 게 존재
			
			nx += dr[dir];
			ny += dc[dir];
		}
		
		return true;
	}

	public static class Points{
		int x, y;
		public Points(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
