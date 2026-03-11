import java.io.*;
import java.util.*;

public class Solution {
	public static class Edge implements Comparable<Edge> {
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

	static int V, E;
	static ArrayList<Edge>[] graph;
	static boolean[] visited;
	static int[] dist;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			visited = new boolean[V + 1];
			dist = new int[V + 1];

			graph = new ArrayList[V + 1];
			for (int i = 1; i <= V; i++) {
				graph[i] = new ArrayList<>();
				dist[i] = INF;
			}

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());

				graph[start].add(new Edge(end, weight));
				graph[end].add(new Edge(start, weight));
			}

			long result = prim(1);
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

	static public long prim(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(start, 0));

		int cnt = 0; // 연결 간선 수
		long total = 0; // 연결 간선들의 가중치 합
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			int minIdx = cur.to;
			int minDist = cur.w;

			if (!visited[minIdx]) {
				visited[minIdx] = true;
				cnt++;
				total += minDist;

				for (Edge next : graph[minIdx]) {
					if (!visited[next.to] && next.w < dist[next.to]) {
						dist[next.to] = next.w;
						pq.offer(new Edge(next.to, next.w));
					}
				}
				
				if (cnt == V)
				break;
			}
		}
		return total;
	}
}
