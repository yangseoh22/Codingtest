import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for(int t=1; t<=TC; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[][] map = new int[N][N];
			for(int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			// M x M 파리채 영역의 파리 수
			int max = Integer.MIN_VALUE;
			
			for(int r=0; r<N-M+1; r++) {
				for(int c=0; c<N-M+1; c++) {
					int sum = 0;
					// 파리채
					for(int i=r; i<r+M; i++) {
						for(int j=c; j<c+M; j++) {
							sum += map[i][j];
						}
					}
					max = Math.max(max, sum);
				}
			}
			
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}

}
