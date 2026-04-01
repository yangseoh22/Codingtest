import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Integer>[] graph;
	static int N, M, cnt=0;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
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
			if(!visited[i]) {
				DFS(i);
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	private static void DFS(int node) {
		if(visited[node]) return;
		visited[node] = true;
		
		for(int n : graph[node]) {
			if(!visited[n]) DFS(n);
		}
		
	}
	
}
