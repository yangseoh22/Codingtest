import java.io.*;
import java.util.*;

public class Solution {
	public static class Edge implements Comparable<Edge>{
		int to;
		long weight;
		public Edge(int to, long weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge e) {
			return Long.compare(this.weight, e.weight);
		}
	}
	
	static ArrayList<Edge>[] graph;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());

			int[][] points = new int[N][2];

			// 각 섬의 x좌표
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				points[i][0] = Integer.parseInt(st.nextToken());
			}

			// 각 섬의 y좌표
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				points[i][1] = Integer.parseInt(st.nextToken());
			}
			
			// 환경 부담금
			double E = Double.parseDouble(br.readLine());
			
			graph = new ArrayList[N];
			for(int i=0; i<N; i++) {
				graph[i] = new ArrayList<>();
			}
			
			// 거리 계산 및 그래프 생성
			for(int i=0; i<N; i++) {
				for(int j=i+1; j<N; j++) {
					long x = points[i][0] - points[j][0];
					long y = points[i][1] - points[j][1];
					long dist = x*x + y*y;  // 문제 요구에 따르면 어차피 L제곱을 해야하므로 놔두기
					
					graph[i].add(new Edge(j, dist));
					graph[j].add(new Edge(i, dist));
				}
			}
			
			// Prim
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			visited = new boolean[N];
			pq.offer(new Edge(0, 0));
			
			double result = 0;
			while(!pq.isEmpty()) {
				Edge cur = pq.poll();
				
				if(visited[cur.to]) continue;
				
				visited[cur.to] = true;
				result += E * cur.weight;
				
				for(Edge next : graph[cur.to]) {
					if(!visited[next.to]) {
						pq.add(next);
					}
				}
			}
			
			sb.append("#").append(t).append(" ").append(Math.round(result)).append("\n");
		}
		System.out.println(sb);
	}
}
