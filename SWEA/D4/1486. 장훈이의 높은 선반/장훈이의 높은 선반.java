import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=TC; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());  // 점원의 수
			int B = Integer.parseInt(st.nextToken());  // 선반 높이
			
			int[] heights = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				heights[i] = Integer.parseInt(st.nextToken());
			}
			
			// 점원 부분집합으로 키의 합 확인
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < (1 << N); i++) {
				int total = 0;
				for(int j = 0; j < N; j++) {
					if((i & (1 << j)) != 0 ) {
						total += heights[j];
					}
				}
				
				if(total>=B) {
					min = Math.min(total, min);
				}
			}
			
			sb.append("#").append(t).append(" ").append(min-B).append("\n");
		}
		System.out.println(sb);
	}

}
