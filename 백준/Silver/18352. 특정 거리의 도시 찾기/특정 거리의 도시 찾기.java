import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<int[]>[] graph;
	static PriorityQueue<int[]> pq;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			graph[from].add(new int[] {to, 1});
		}

		pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		pq.add(new int[] {X, 0});
		dist[X] = 0;
		
		while(!pq.isEmpty()) {
			int[] now = pq.poll();

			if(now[1] > dist[now[0]]) continue;
			
			for(int[] next : graph[now[0]]) {
				int newDist = dist[now[0]] + next[1];
				if(dist[next[0]]>newDist) {
					dist[next[0]] = newDist;
					pq.add(new int[] {next[0], newDist});
				}
			}
		}
		
		boolean find = false;
		for(int i=1; i<=N; i++) {
			if(dist[i] == K) {
				find = true;
				sb.append(i).append("\n");
			}
		}
		
		if(!find) sb.append(-1);
		
		System.out.println(sb);
	}

}
