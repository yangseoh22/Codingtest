import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] indegree = new int[N+1];
		ArrayList<Integer>[] edge = new ArrayList[N+1];
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			edge[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			edge[a].add(b);
			indegree[b]++;
		}
		
        int cnt = 0;
		for(int i=1; i<=N; i++) {
			if(indegree[i]==0){
                cnt++;
                q.add(i);
            }
		}
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			// 순서 출력
			
			for(int next : edge[now]) {
				indegree[next]--;
				
				if(indegree[next]==0) {
					q.add(next);
					cnt++;
				}
			}
		}
		
		sb.append(cnt==N? "Consistent" : "Inconsistent" );
		
		System.out.println(sb);
	}
}
