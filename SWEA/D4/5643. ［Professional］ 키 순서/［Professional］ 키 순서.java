import java.util.*;
import java.io.*;

public class Solution {
	static ArrayList<Integer>[] taller;
	static ArrayList<Integer>[] shorter;
	static int N, M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			taller = new ArrayList[N+1];
			shorter = new ArrayList[N+1];
			for(int i=1; i<=N; i++) {
				taller[i] = new ArrayList<>();
				shorter[i] = new ArrayList<>();
			}
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				taller[from].add(to);
				shorter[to].add(from);
			}
			
			int tallCnt = 0;  // 나보다 큰 사람 수
			int shortCnt = 0;  // 나보다 작은 사람 수
			int result = 0;  // 나의 위치를 아는 사람 수
			for(int i=1; i<=N; i++) {
				tallCnt = BFS(i, taller);
				shortCnt = BFS(i, shorter);
				
				if(tallCnt + shortCnt == N-1) result++;
			}
			
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
	private static int BFS(int start, ArrayList<Integer>[] graph) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		q.add(start);
		visited[start] = true;
		
		int cnt = 0;
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int next : graph[now]) {
				if(!visited[next]) {
					visited[next] = true;
					q.add(next);
					cnt++;
				}
			}
		}
		
		return cnt;
	}

}
