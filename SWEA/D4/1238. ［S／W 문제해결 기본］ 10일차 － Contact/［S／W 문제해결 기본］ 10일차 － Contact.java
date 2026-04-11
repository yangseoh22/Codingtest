import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	static ArrayList<Integer>[] graph;
	static int[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = 10;
		
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList[101];
			for(int i=1; i<=100; i++) {
				graph[i] = new ArrayList<>();
			}

			visited = new int[101];
			Arrays.fill(visited, -1);
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N/2; i++) {
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				
				graph[s].add(e);
			}
			
			BFS(start);
			
			int maxCnt = Integer.MIN_VALUE;
			int number = 0;
			for(int i=1; i<=100; i++) {
				if(maxCnt<=visited[i]) {
					maxCnt = visited[i];
					number = i;
				}
			}
			
			sb.append(number).append("\n");
		}
		
		System.out.println(sb);
	}
	private static void BFS(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = 0;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			// 다음 노드로 가면서 1증가
			for(int next : graph[now]) {
				if(visited[next] == -1) {  // 아직 방문하지 않았다면
					visited[next] = visited[now] + 1;
					q.add(next);
				}
			}
			
		}
	}

}
