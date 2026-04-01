import java.util.*;
import java.io.*;

public class Main {
	static int N, cnt = 0;
	static boolean[] visited;
	static Queue<int[]> q = new LinkedList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		visited = new boolean[1000001];
		q.add(new int[] {N, 0});
		bfs();
		
		System.out.println(cnt);
	}
	private static void bfs() {
		
		while(!q.isEmpty()) {
			int[] n = q.poll();
			int now = n[0];
			int nowCnt = n[1];
			visited[now] = true;
			
			if(now == 1) {
				cnt = nowCnt;
				return;
			}
			
			if(now/3>0 && now/3<1000001) {
				if(now%3==0) {
					q.add(new int[] {now/3, nowCnt+1});
					visited[now/3] = true;
				}
			}
			if(now/2>0 && now/2<1000001) {
				if(now%2==0) {
					q.add(new int[] {now/2, nowCnt+1});
					visited[now/2] = true;
				}
			}
			if(now-1>0 && now-1<1000001) {
				q.add(new int[] {now-1, nowCnt+1});
				visited[now-1] = true;
			}
		}
		
	}
	
}
