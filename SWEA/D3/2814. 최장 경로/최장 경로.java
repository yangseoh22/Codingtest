import java.util.*;
import java.io.*;

public class Solution {
	static int N, M;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static int maxLen;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			maxLen = Integer.MIN_VALUE;
			
			if(N == 1) {
				maxLen = 1;
				continue;
			}
			
			graph = new ArrayList[N+1];
			for(int i=1; i<=N; i++) {
				graph[i] = new ArrayList<>();
			}
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				
				graph[s].add(e);
				graph[e].add(s);
			}
			
			visited = new boolean[N+1];
			for(int i=1; i<=N; i++) {
				visited[i] = true;
				DFS(i, 1);
				visited[i] = false;
			}
			
			sb.append("#").append(t).append(" ").append(maxLen).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void DFS(int now, int cnt) {
		maxLen = Math.max(maxLen, cnt);
		
		for(int next : graph[now]) {
			if(!visited[next]) {
				visited[next] = true;
				DFS(next, cnt+1);
				visited[next] = false;
			}
		}
	}

}
