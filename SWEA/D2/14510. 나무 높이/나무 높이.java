import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=TC; t++) {
			sb.append("#").append(t).append(" ");
			int N = Integer.parseInt(br.readLine());
			
			int[] tree = new int[N];
			int maxH = Integer.MIN_VALUE;
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				tree[i] = Integer.parseInt(st.nextToken());
				maxH = Math.max(maxH, tree[i]);
			}
			
			int[] diff = new int[N];
			for(int i=0; i<N; i++) {
				diff[i] = Math.abs(maxH-tree[i]);
			}
			
			int two = 0;
			int one = 0;
			for(int i=0; i<N; i++) {
				two += diff[i]/2;
				one += diff[i]%2;
			}
			
			while(one+1 < two) {
				two--;
				one+=2;
			}
			
			if(one>two) sb.append(one*2-1);
			else sb.append(two*2);
			sb.append("\n");
		}
		
		
		System.out.println(sb);
	}

}
