import java.io.*;
import java.util.*;

public class Main{
	static int N, M;
	static int[][] map;
	static boolean[][] V;
	static int[] dr  = {-1, 1, 0, 0};
	static int[] dc  = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		V = new boolean[N][M];
		sb.append(bfs(0, 0)? 1 : 0);
		
		System.out.println(sb);
	}

	public static boolean bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		V[r][c] = true;
		q.offer(new int[] {r, c});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nr = now[0];
			int nc = now[1];
			
			if(nr==N-1 && nc==M-1) return true;
			
			for(int i=0; i<4; i++) {
				int nnr = nr + dr[i];
				int nnc = nc + dc[i];
				
				if(nnr<0 || nnr>=N || nnc<0 || nnc>=M) continue;
				
				if(!V[nnr][nnc] && map[nnr][nnc] == 1) {
					V[nnr][nnc] = true;
					q.offer(new int[] {nnr, nnc});
				}
			}
		}
		
		return false;
	}
}
