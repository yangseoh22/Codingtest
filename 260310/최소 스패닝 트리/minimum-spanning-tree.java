import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
	int s, e, w;
	
	public Edge(int s, int e, int w) {
		this.s = s;
		this.e = e;
		this.w = w;
	}
	
	@Override
	public int compareTo(Edge o) {
		return Integer.compare(this.w, o.w);
	}
}

public class Main {
	static int[] uf;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Edge[] edges = new Edge[M];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			edges[i] = new Edge(a, b, w);
		}
		
		Arrays.sort(edges);  // 가중치 기준 오름차순 정렬
		
		// 서로소 집합 생성
		uf = new int[N+1];
		for(int i=1; i<=N; i++) {
			uf[i] = i;
		}
		
		int cnt = 0;
		int result = 0;
		for (Edge ed : edges) {
			if(union(ed.s, ed.e)) {
				result += ed.w;  // 가중치 누적
				cnt++;  // 선택 간선 수
				if(cnt == N-1) break;
			}
		}
		
		System.out.println(result);
	}

	private static boolean union(int u, int v) {
		int nodeU = find(u);
		int nodeV = find(v);
		
		// 사이클이 발생하므로 연결 하지 않음
		if(nodeU == nodeV) return false; 
		
		uf[nodeU] = nodeV;
		return true;
	}

	private static int find(int x) {
		if(uf[x]==x) return x;
		int rootX = find(uf[x]);
		uf[x] = rootX;
		return rootX;
	}

}
