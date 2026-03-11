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
	static long result;
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
			
			graph = new ArrayList[V+1];
			for(int i=1; i<=V; i++) {
				graph[i] = new ArrayList<>();
			}
			
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				graph[start].add(new Edge(end, weight));
				graph[end].add(new Edge(start, weight));
			}
			
			prim(1);  // 임의로 1번 노드에서 시작
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

	static public void prim(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(start, 0));
		
		int cnt = 0;
		result = 0;
		while(!pq.isEmpty()) {
			Edge curr = pq.poll();
			
			if(visited[curr.to]) continue;  // 방문했던 노드면 무시
			
			visited[curr.to] = true;  // 방문
			cnt++;
			result += curr.w;  // 선택 간선 가중치 누적 합
			
			// 선택한 노드의 인접 노드 확인
			for(Edge next : graph[curr.to]) {
				if(!visited[next.to]) {
					pq.offer(next);
				}
			}
			
			if(cnt==V) break;  // 모든 노드가 이미 선택이 끝났으면 조기 종료
		}
	}
}
