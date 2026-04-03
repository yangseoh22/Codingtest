import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Edge>[] graph;
	static int N, M;
	static boolean[] visited;
	static int[] dist;
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		visited = new boolean[N+1];
		dist = new int[N+1];
		for(int i=1; i<=N; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			graph[from].add(new Edge(to, weight));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
				
		dist[start] = 0;
		pq.add(new Edge(start, 0));
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			if(visited[now.to]) continue;
			visited[now.to] = true;
			
			for(Edge next : graph[now.to]) {
				int newDist = next.weight + dist[now.to];
				if(newDist<dist[next.to]) {
					dist[next.to] = newDist;
					pq.add(new Edge(next.to, newDist));
				}
			}
		}
		
		sb.append(dist[goal]);
		System.out.println(sb);
	}
	
	static public class Edge implements Comparable<Edge>{
		int to, weight;
		public Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge e) {
			return this.weight - e.weight;
		}
	}
}
