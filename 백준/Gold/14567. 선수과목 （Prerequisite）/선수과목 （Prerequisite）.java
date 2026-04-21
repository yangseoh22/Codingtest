import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Integer>[] graph;
	static int[] degree;
	static int[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		degree = new int[N+1];
		visited = new int[N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			graph[s].add(e);
			degree[e]++;
		}
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			if(degree[i] == 0) {
				visited[i] = 1;
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int next : graph[now]){
				if(visited[next] == 0) {
					degree[next]--;
					
					if(degree[next] == 0) {
						visited[next] = visited[now] + 1;
						q.add(next);
					}
				}
			}
		}
		
		for(int i=1; i<=N; i++) {
			sb.append(visited[i]).append(" ");
		}
		System.out.println(sb);
	}

}
