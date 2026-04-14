/*
 * 시간 : 
 * 메모리 : 
 */

import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Edge>[] graph;
	static PriorityQueue<Edge> pq;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			graph[start].add(new Edge(end, weight));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
		
		int[] dist = new int[N+1];
		for(int i=1; i<=N; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.add(new Edge(start, dist[start]));
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			
			if(now.w > dist[now.to]) continue;
			
			for(Edge next : graph[now.to]) {
				int newDist = dist[now.to] + next.w;
				if(dist[next.to]>newDist) {
					dist[next.to] = newDist;
					pq.add(new Edge(next.to, newDist));
				}
			}
		}
		
		System.out.println(dist[goal]);
	}
	
	public static class Edge implements Comparable<Edge>{
		int to, w;
		
		public Edge(int to, int w) {
			this.to = to;
			this.w = w;
		}
		
		@Override
		public int compareTo(Edge e) {
			return this.w - e.w;
		}
	}
}
