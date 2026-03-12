import java.io.*;
import java.util.*;

public class Main {
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
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		List<Edge>[] graph = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			graph[A].add(new Edge(B, 1));  // 가중치 없는 그래프라 모두 1
		}

		int[] dist = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			dist[i] = (int) 1e9;
		}
		
		dist[X] = 0;  // 시작점
		pq.add(new Edge(X, 0));
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			int minIdx = cur.to;
			int minDist = cur.weight;
			
			if(minDist != dist[minIdx]) continue;

			// 인접 노드 확인
			for(Edge next : graph[minIdx]) {
				// 다음에 가려는 곳의 거리가 현재 노드를 거쳐 가는 것보다 크다면 갱신
				if(dist[next.to] > dist[minIdx]+next.weight) {
					dist[next.to] = dist[minIdx]+next.weight;
					pq.add(new Edge(next.to, dist[next.to]));
				}
			}
		}

		boolean flag = false;
		for (int i = 1; i <= N; i++) {
			if (dist[i] == K) {
				flag = true;
				sb.append(i).append("\n");
			}
		}
		if(!flag) System.out.println(-1);
		else System.out.println(sb);
	}

}
