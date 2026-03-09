import java.io.*;
import java.util.*;

public class Solution {

	static boolean[][] V;
	static char[][] map;
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, -1, -1, -1, 0, 1, 1, 1};
	static int N, cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			
			N = Integer.parseInt(br.readLine());
			cnt = 0;
			
			map = new char[N][N];
			V= new boolean[N][N];
			for(int r=0; r<N; r++) {
				String str = br.readLine();
				for(int c=0; c<N; c++) {
					map[r][c] = str.charAt(c);
					
					if(map[r][c]=='*') V[r][c] = true;
				}
			}
			
			// 인접 칸 확인
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(map[r][c] == '.' && !V[r][c] && isZero(r, c)) {
						cnt++;
						BFS(r, c);
					}
				}
			}
			
			// 나머지 클릭
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(map[r][c] == '.' && !V[r][c]) {
						cnt++;
					}
				}
			}
			sb.append(cnt).append("\n");
		}

		System.out.println(sb);
	}

	public static boolean isZero(int r, int c) {
		for(int k=0; k<8; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			
			if(!(nr>=0 && nc>=0 && nr<N && nc<N)) continue;
			
			if(map[nr][nc] == '*') return false;
		}
		return true;
	}
	
	private static void BFS(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {r, c});
		V[r][c] = true;
		
		while(!q.isEmpty()) {
			int now[] = q.poll();
			int cr = now[0];
			int cc = now[1];
			
			if(isZero(cr, cc)) {
				for(int k=0; k<8; k++) {
					int nr = cr + dr[k];
					int nc = cc + dc[k];
					
					if(nr>=0 && nc>=0 && nr<N && nc<N && map[nr][nc]=='.' && !V[nr][nc]) {
						V[nr][nc] = true;
						q.offer(new int[] {nr, nc});
					}
				}
			}
		}
	}

}
