import java.io.*;
import java.util.*;

public class Main {
	static int[] uf;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 루트 노드 저장 배열
		uf = new int[N+1];
		for(int i=1; i<=N; i++) {
			uf[i] = i;
		}
		
		// 간선 연결
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			union(a, b);
		}
		
		// ------- K개의 정점이 같은 집합에 있는가?
		
		// 확인할 정점 배열
		int[] nodes = new int[K];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++) {
			nodes[i] = Integer.parseInt(st.nextToken());
		}
		
		// 첫 번째 정점, 두 번째 정점 비교 => 그 다음 정점 비교
		int prev = find(nodes[0]);
		boolean isConnected = false;
		for(int i=1; i<K; i++) {
			if(prev != find(nodes[i])) break;
			
			prev = find(nodes[i]);
		}
		
		if(!isConnected) sb.append(1);
		else sb.append(0);
		
		System.out.println(sb);
	}

	private static void union(int a, int b) {
		int nodeA = find(a);
		int nodeB = find(b);
		
		uf[nodeA] = nodeB;
	}

	private static int find(int x) {
		if(uf[x] == x) return x;
		int rootX = find(uf[x]);
		uf[x] = rootX;
		return rootX;
	}

}
