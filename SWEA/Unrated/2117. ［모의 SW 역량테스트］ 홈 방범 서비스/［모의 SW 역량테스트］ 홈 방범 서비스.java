import java.util.*;
import java.io.*;

public class Solution {
	static int[][] map;
	static int N, M;
	static ArrayList<int[]> points;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());  // 지불 비용
			
			map = new int[N][N];
			points = new ArrayList<>();
			for(int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					if(map[r][c]==1) points.add(new int[] {r, c});
				}
			}
			
			// 운영비용(cost) =  K*K + (K-1)*(K-1)
			// 이익(A) = 영역 포함 집 개수(cnt) * M - cost
			
			int A = 0;
			int maxCnt = Integer.MIN_VALUE;
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					for(int k=1; k<=N+1; k++) {
						int cnt = 0;
						for(int[] p : points) {
							int dist = Math.abs(r-p[0]) + Math.abs(c-p[1]);
							if(dist<k) cnt++;
						}
						A = cnt*M - (k*k + (k-1)*(k-1));
						if(A>=0 && cnt>maxCnt) {
							maxCnt = cnt;
						}
					}
				}
			}
			
			sb.append("#").append(t).append(" ").append(maxCnt).append("\n");
		}
		System.out.println(sb);
	}

}
