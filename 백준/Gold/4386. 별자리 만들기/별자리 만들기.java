import java.io.*;
import java.util.*;

public class Main {
	public static class Point {
		double x, y;

		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}

	public static class Edge implements Comparable<Edge>{
		int to;
		double dist;

		public Edge(int to, double dist) {
			this.to = to;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Edge e) {
			return Double.compare(this.dist, e.dist);
		}
	}

	static int N;
	static ArrayList<Edge>[] graph;
	static ArrayList<Point> stars;
	static int[] starComb;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		graph = new ArrayList[N+1];
		for(int i=0; i<N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		stars = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			double starX = Double.parseDouble(st.nextToken());
			double starY = Double.parseDouble(st.nextToken());
			stars.add(new Point(starX, starY));
		}

		// 별을 2개 고르는 조합과 해당 거리 구하기
		starComb = new int[2];
		combi(0, 0);
		
		visited = new boolean[N];
		
		//prim 알고리즘
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(0, 0));  // 임의로 0번 별 시작
		
		double result = 0;
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			if(visited[cur.to]) continue;
			
			result += cur.dist;
			visited[cur.to] = true;
			
			for(Edge next : graph[cur.to]) {
				if(!visited[next.to]) {
					pq.offer(next);
				}
			}
		}
		
		System.out.printf("%.2f", result);
	}

	// N개 중에 2개 고르는 조합 구하기
	private static void combi(int idx, int start) {
		if(idx == 2) {
			calDist(starComb);
			return;
		}
		
		for(int i=start; i<N; i++) {
			starComb[idx] = i;
			combi(idx + 1, i+1);
		}
	}

	// 별 조합들의 거리 계산 및 그래프 생성
	private static void calDist(int[] starList) {
		// 별들의 거리 계산
		int starIdx = starList[0];
		int starNext = starList[1];

		// 두 별의 거리 계산
		double x1 = stars.get(starIdx).x;
		double y1 = stars.get(starIdx).y;
		double x2 = stars.get(starNext).x;
		double y2 = stars.get(starNext).y;

		double starDist = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
		
		// 그래프 생성
		graph[starIdx].add(new Edge(starNext, starDist));
		graph[starNext].add(new Edge(starIdx, starDist));
	}
}
