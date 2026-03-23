
import java.util.*;
import java.io.*;

public class Main {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int N, num, cnt;
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
		ArrayList<Integer> result = new ArrayList<>();
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c]==-1 && !V[r][c]) {
					num++;
					cnt = 0;
					dfs(r, c);
					result.add(cnt);
				}
			}
		}
		
		sb.append(num).append("\n");
		Collections.sort(result);
		for(int r : result) {
			sb.append(r).append("\n");
		}
		System.out.println(sb);
	}
	private static void dfs(int r, int c) {
		
		V[r][c] = true;
		cnt++;
		
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
