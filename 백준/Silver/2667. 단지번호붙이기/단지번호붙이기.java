import java.util.*;
import java.io.*;

public class Main {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int N, num;
	static int[][] map;
	static boolean[][] V;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for(int r=0; r<N; r++) {
			 String lines = br.readLine();
			for(int c=0; c<N; c++) {
				int tmp = lines.charAt(c) - '0';
				if(tmp== 1) map[r][c] = -1;
				else map[r][c] = tmp;
			}
		}
		
		V = new boolean[N][N];
		num = 0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c]==-1) {
					num++;
					dfs(r, c);
				}
			}
		}
		
		sb.append(num).append("\n");
		int[] tmp = new int[num + 1];
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c] != 0) {
					tmp[map[r][c]]++;
				}
			}
		}
		
		Arrays.sort(tmp);
		for(int i=0; i<num; i++) {
			sb.append(tmp[i+1]).append("\n");
		}
		
		System.out.println(sb);
	}
	private static void dfs(int r, int c) {
		
		map[r][c] = num;
		V[r][c] = true;
		
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr>=0 && nr<N && nc>=0 && nc<N) {
				if(!V[nr][nc] && map[nr][nc] == -1) {
					dfs(nr, nc);
				}
			}
		}
	}

}
