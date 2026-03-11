import java.io.*;
import java.util.*;

public class Main {
	static class Edge implements Comparable<Edge>{
		int to, w;
		
		public Edge(int to, int w) {
			this.to = to;
			this.w = w;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
	}
	
	static ArrayList<Edge>[] graph;
	static boolean[] V;
	static int[] dist;
	static int N, M;
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		dist = new int[N+1];
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
			dist[i] = INF;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[s].add(new Edge(e, w));
			graph[e].add(new Edge(s, w));
		}
		
		V = new boolean[N+1];
		int result = prim(1);
		
		System.out.println(result);
	}
	private static int prim(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(start, 0));
		
		int total = 0;
		int cnt = 0;
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			int minIdx = cur.to;
			int minDist = cur.w;
			
			// 방문 노드라면 스킵
			if(V[minIdx]) continue;
			
			// 방문 처리 및 가중치 합산
			V[minIdx] = true;
			total += minDist;
			cnt++;
			
			// 현재 정점과 연결된 간선을 pq에 넣기
			for(Edge next : graph[minIdx]) {
				if(!V[next.to] && next.w < dist[next.to]) {
					dist[next.to]= next.w;
					pq.offer(next);
				}
			}
			
			// 모든 정점을 방문했다면 조기 종료
			if(cnt == N) break;
		}
		
		return total;
	}

}
