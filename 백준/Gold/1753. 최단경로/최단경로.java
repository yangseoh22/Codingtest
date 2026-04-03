import java.util.*;
import java.io.*;

public class Main {
	static int V, E, K;
	static int[] dist;
	static boolean[] visited;
	static ArrayList<Edge>[] graph;
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[V+1];
		for(int i=0; i<=V; i++) {
			graph[i] = new ArrayList<>();
		}
		
		dist = new int[V+1];
		for(int i=1; i<=V; i++) {
			dist[i] = INF;
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			graph[from].add(new Edge(to, weight));
		}
		
		visited = new boolean[V+1];
		dist[K] = 0;
		dijkstra(K);
		
		for(int i=1; i<=V; i++) {
			if(dist[i] == INF) sb.append("INF").append("\n");
			else sb.append(dist[i]).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
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
	}

	public static class Edge implements Comparable<Edge>{
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
