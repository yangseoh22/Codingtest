import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Integer>[] graph;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		int[] degree = new int[N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int prev = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			
			graph[prev].add(next);
			degree[next]++;
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=1; i<=N; i++) {
			if(degree[i] == 0) {
				pq.add(i);
			}
		}
		
		while(!pq.isEmpty()) {
			int now = pq.poll();
			sb.append(now).append(" ");
			
			for(int next : graph[now]) {
				degree[next]--;
				
				if(degree[next]==0) pq.add(next);
			}
		}
		
		System.out.println(sb);
	}

}
