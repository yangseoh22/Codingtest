import java.io.*;
import java.util.*;

public class Solution {
	static int[] person;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			person = new int[N+1];
			for(int i=1; i<=N; i++) {
				person[i] = i;
			}
			
			// 집합 생성
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				union(a, b);
			}
			
			int[] group = new int[N+1];
			// 루트 개수 = 무리 개수
			for(int i=1; i<=N; i++) {
				group[find(i)]++;
			}
			
			int cnt = 0;
			for(int g : group) {
				if(g != 0) cnt++;
			}
			
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}

	private static int find(int i) {
		if(person[i] == i) return i;
		int rootN = find(person[i]);
		person[i] = rootN;
		return rootN;
	}

	private static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		person[rootA] = rootB;
	}

}
