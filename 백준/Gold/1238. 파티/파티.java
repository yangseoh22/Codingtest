import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Edge>[] graph;
	static int N, M, K;
	static int[][] dist;
	static final int INF = Integer.MAX_VALUE;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		// ------여기에 솔루션 코드를 작성하세요.------------
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());

			graph[s].add(new Edge(e, t));
		}

		dist = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				dist[i][j] = INF;
			}
		}

		// 각 요원별로 K번에 다녀오는 경로
		for (int i = 1; i <= N; i++) {
			// 가는 시간 : K 제외 요원의 다익스트라 결과의 2번에 해당하는 값
			// 오는 시간 : K번에서 시작한 다익스트라 결과

			dist[i][i] = 0;
			dijk(i);
		}

		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			if (i == K)
				continue;
			max = Math.max(max, dist[i][K] + dist[K][i]);
		}

		System.out.println(max);
	}

	private static void dijk(int num) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();

		pq.offer(new Edge(num, 0));

		while (!pq.isEmpty()) {
			Edge now = pq.poll();

			if (now.time > dist[num][now.to])
				continue;

			for (Edge next : graph[now.to]) {
				int newDist = dist[num][now.to] + next.time;
				if (dist[num][next.to] > newDist) {
					dist[num][next.to] = newDist;
					pq.offer(new Edge(next.to, newDist));
				}

			}
		}

	}

	public static class Edge implements Comparable<Edge> {
		int to, time;

		public Edge(int to, int time) {
			this.to = to;
			this.time = time;
		}

		@Override
		public int compareTo(Edge e) {
			return this.time - e.time;
		}
	}
}