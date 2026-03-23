import java.util.*;
import java.io.*;

public class Main {
	static Edge[] edges;
	static int V, E;
	static int[] uf;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		edges = new Edge[E];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			edges[i] = new Edge(start, end, w);
		}
		
		// 엣지들 정렬
		Arrays.sort(edges);
		
		uf = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			uf[i] = i;
		}
		
		int cost = 0; // 선택된 비용 합
		int cnt = 0;  // 선택 간선 수
		for(Edge e : edges) {
			// 사이클 발생 안하면, 병합
			if(union(e.from, e.to)) {
				cost += e.weight;
				cnt++;
			}
			
			if(cnt == V-1) break;  // 간선을 모두 선택했으니 종료
		}
		
		System.out.println(cost);
	}

	private static boolean union(int from, int to) {
		int nodeF = find(from);
		int nodeT = find(to);
		
		if(nodeF == nodeT) return false;
		
		uf[nodeF] = nodeT;
		return true;
	}

	private static int find(int x) {
		if(uf[x] == x) return x;
		int rootX = find(uf[x]);
		uf[x] = rootX;
		return rootX;
	}

	public static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		// 최소 가중치가 먼저
		@Override
		public int compareTo(Edge e) {
			return this.weight - e.weight;
		}
	}
}
