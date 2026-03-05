import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N, M;
	static ArrayList<Integer>[] taller;
	static ArrayList<Integer>[] shorter;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=TC; t++) {
			N = Integer.parseInt(br.readLine());  //학생 수
			M = Integer.parseInt(br.readLine());  //키 비교 횟수 = 간선 수
			
			taller = new ArrayList[N+1];
			shorter = new ArrayList[N+1];
			for(int i=1; i<=N; i++) {
				taller[i] = new ArrayList<>();
				shorter[i] = new ArrayList<>();
			}
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				taller[a].add(b);
				shorter[b].add(a);
			}
			
			int result = 0;
			// 모든 학생을 시작점으로 BFS
			for(int s=1; s<=N; s++) {
				int tallCnt = BFS(s, taller);
				int shortCnt = BFS(s, shorter);
				
				// 자신의 위치 파악 가능
				if(tallCnt + shortCnt == N-1) {
					result++;
				}
			}
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

	private static int BFS(int s, ArrayList<Integer>[] graph) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		
		q.add(s);
		visited[s] = true;
		
		int cnt = 0;
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			for(int next : graph[curr]) {
				if(!visited[next]) {
					q.add(next);
					visited[next] = true;
					cnt++;
				}
			}
		}
		
		return cnt;
	}

}
