import java.util.*;
import java.io.*;

public class Main {
	static int N, M, cnt;
	static ArrayList<Integer>[] arr;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		arr = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			arr[start].add(end);
			arr[end].add(start);
		}
		
		cnt = 0;
		visited = new boolean[N+1];
		dfs(1);
		
		System.out.println(cnt);
	}
	
	private static void dfs(int start) {
		visited[start] = true;
		
		for(int next : arr[start]) {
			if(!visited[next]) {
				cnt++;
				dfs(next);
			}
		}
	}

}
