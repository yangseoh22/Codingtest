import java.io.*;
import java.util.*;

public class Main{
	static int N, personCnt;
	static int[][] map;
	static int landCnt;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		map	= new int[N][N];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		landCnt = 0;
		ArrayList<Integer> arr = new ArrayList<>();
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c] == 1) {
					landCnt++;
					dfs(r, c);
					arr.add(personCnt);
					personCnt = 0;
				}
			}
		}
		
		Collections.sort(arr);
		
		sb.append(landCnt).append("\n");
		for(int a : arr) {
			sb.append(a).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void dfs (int r, int c) {
		
		map[r][c] = 0;
		personCnt++;
		
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr>=0 && nr<N && nc>=0 && nc<N) {
				if(map[nr][nc]==1) dfs(nr, nc);
			}
		}
		
	}
}
