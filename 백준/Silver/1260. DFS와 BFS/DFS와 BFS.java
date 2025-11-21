import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m, v;
	static boolean dfs_visited[];
	static boolean bfs_visited[];
	static ArrayList<Integer>[] a;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 정점의 개수
        int m = Integer.parseInt(st.nextToken()); // 간선의 개수
        int v = Integer.parseInt(st.nextToken()); // 시작 노드
		
		a = new ArrayList[n+1];
		
		// 인접리스트 생성 (인덱스 1~n)
		for(int i=1; i<=n; i++) {
			a[i] = new ArrayList<Integer>();
		}
		
		// 간선 생성
		for(int i=0; i<m; i++) {
			 st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			a[s].add(e);
			a[e].add(s);	
		}
		
		// 정점 정렬
		for(int i=1; i<=n; i++) {
			Collections.sort(a[i]);
		}
		
		dfs_visited = new boolean[n+1];
		DFS(v);
		
		sb.append("\n");
		
		bfs_visited = new boolean[n+1];
		BFS(v);
		
		System.out.println(sb);
		
	}

	// 재귀 함수를 이용한 DFS
	private static void DFS(int n) {
		dfs_visited[n] = true;  // 방문 표시
		sb.append(n).append(" ");
		
		// 인접 노드들 중 방문 안한 노드는 DFS 호출
		for (int next : a[n]) {
			if(!dfs_visited[next]) DFS(next);
		}
	}
	
	// 큐를 이용한 BFS
	private static void BFS(int n) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(n);  // 시작 노드를 큐에 넣기
		bfs_visited[n] = true;  // 시작 노드 방문 표시
		
		while(!q.isEmpty()) {
			int node = q.poll();  // 큐에서 노드 하나 꺼냄
			sb.append(node).append(" ");
			
			for (int next : a[node]) {
				if(!bfs_visited[next]) {
					bfs_visited[next] = true;  // 방문 표시 후
					q.add(next);  // 큐에 넣음
				}
			}
		}
	}

}
