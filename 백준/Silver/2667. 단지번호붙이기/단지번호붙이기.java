/*
 * 시간 : 68ms
 * 메모리 : 11,540kb
 * 전략 : DFS
 * 1. 각 마을별로 번호를 매기기 위해 1을 모두 -1으로 저장
 * 2. DFS 4방향 탐색으로 방문하지 않았고, -1인 곳이 인접하다면 다 같은 마을로 계산
 * 3. 해당 탐색을 하면서 마을 개수 계산
 * 4. 모든 탐색이 끝나면, 해당 배열에 마을 번호마다 몇 개씩 존재 하는지 세서 배열 생성
 * 5. 오름차순 정렬 후 출력
 */

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
