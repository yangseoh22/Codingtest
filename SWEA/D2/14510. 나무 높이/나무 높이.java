import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for(int t=1; t<=TC; t++) {
			
			int N = Integer.parseInt(br.readLine());
			int[] trees = new int[N];
			
			int maxT = Integer.MIN_VALUE;
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				trees[i] = Integer.parseInt(st.nextToken());
				maxT = Math.max(maxT, trees[i]);  // 최대 높이
			}
			
			int two = 0;
			int one = 0;
			for(int i=0; i<N; i++) {
				int diff = maxT - trees[i];
				
				two += diff/2;
				one += diff%2;
			}
			
			while(one+1<two) {
				two -= 1;
				one += 2;
			}
			
			int days = 0;
			if(one>two) {
				days = one*2 - 1;
			} else {
				days = two*2;
			}
			
			sb.append("#").append(t).append(" ").append(days).append("\n");
		}
		
		System.out.println(sb);
	}

}
