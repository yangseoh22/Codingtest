import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Integer>[] graph;
	static int N, K;
	static int[] times, totalTime, degree;
	static Queue<Integer> q;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			times = new int[N+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				times[i] = Integer.parseInt(st.nextToken());
			}
			
			graph = new ArrayList[N+1];
			for(int i=1; i<=N; i++) {
				graph[i] = new ArrayList<>();
			}
			
			degree = new int[N+1];
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				graph[x].add(y);
				degree[y]++;
			}
			
			int target = Integer.parseInt(br.readLine());
			
			totalTime = new int[N+1];
			q = new LinkedList<>();
			for(int i=1; i<=N; i++) {
				totalTime[i] = times[i];
				// 진입차수가 0인 곳은 시작점으로 가능
				if(degree[i] == 0) {
					q.add(i);
				}
			}
			
			while(!q.isEmpty()) {
				int now = q.poll();

				if(now == target) {
					break;  // 타겟 번호가 나오면 멈추기
				}
				
				for(int next : graph[now]) {
					totalTime[next] = Math.max(totalTime[next], totalTime[now] + times[next]);
					degree[next]--;
					
					if(degree[next] == 0) {
						q.add(next);
					}
				}
			}
			
			sb.append(totalTime[target]).append("\n");
		}
		System.out.println(sb);
	}

}
