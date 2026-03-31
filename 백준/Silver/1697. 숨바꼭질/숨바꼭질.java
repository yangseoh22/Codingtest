import java.util.*;
import java.io.*;

public class Main {
	static int N, K;
	static int sec = 0;
	static int[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new int[100001];
		
		BFS(N);
		sb.append(visited[K]-1);
		System.out.println(sb);
	}

	private static void BFS(int n) {
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		visited[n] = 1;
		
		while(!q.isEmpty()) {
			int now = q.poll(); 
			
			if(now==K) return;
			
			int[] next = {now*2, now-1, now+1};
			for(int nn : next) {
				if(nn>=0 && nn<=100000 && visited[nn] ==0) {
					visited[nn] = visited[now] + 1;
					q.add(nn);
				}
			}
		}
	}

}
