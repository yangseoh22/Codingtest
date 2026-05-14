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
			
			int[] tree = new int[N];
			int maxH = Integer.MIN_VALUE;
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				tree[i] = Integer.parseInt(st.nextToken());
				maxH = Math.max(maxH, tree[i]);
			}
			
			int two = 0;
			int one = 0;
			for(int i=0; i<N; i++) {
				int diff = maxH - tree[i];
				
				two += diff/2;
				one += diff%2;
			}
			
			while(two - one > 1) {
				two -= 1;
				one += 2;
			}
			
			int day = 0;
			if(one > two) day = one * 2 - 1;
			else day = two * 2;
			
			sb.append("#").append(t).append(" ").append(day).append("\n");
		}
		System.out.println(sb);
	}

}
