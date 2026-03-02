import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] indegree = new int[N+1];
		ArrayList<Integer>[] edges = new ArrayList[N+1];
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1; i<N+1; i++) {
			edges[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			edges[a].add(b);  // 간선 연결
			indegree[b]++;  // 진입 차수 증가
		}
		
		for(int i=1; i<=N; i++) {
			if(indegree[i]==0)
				q.add(i);
		}
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			sb.append(now).append(" ");
			
			for(int i=0; i<edges[now].size(); i++) {
				int next = edges[now].get(i);
				
				indegree[next]--;
				
				if(indegree[next]==0) q.add(next);
			}
		}
		
		System.out.println(sb);
	}

}
