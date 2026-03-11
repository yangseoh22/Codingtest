import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] graph;
	static boolean[] V;
	static int[] dist;
	static int N, M;
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N+1][N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[s][e] = w;
			graph[e][s] = w;
		}
		
		dist = new int[N+1];
		V = new boolean[N+1];
		for(int i=1; i<=N; i++) {
			dist[i] = INF;
		}
		
		dist[1] = 0;  // 시작 정점 : 1번
		
		int result = prim();
		
		System.out.println(result);
	}
	private static int prim() {
		int mst = 0;
		for(int i=1; i<=N; i++) {
			
			int minIdx = -1;
			for(int j=1; j<=N; j++) {
				if(V[j]) continue;
				
				if(minIdx == -1 || dist[minIdx] > dist[j]) minIdx = j;
			}
			
			V[minIdx] = true;
			
			mst += dist[minIdx];
			
			for(int j=1; j<=N; j++) {
				if(graph[minIdx][j]==0) continue;
				
				dist[j] = Math.min(dist[j], graph[minIdx][j]);
			}
		}
		
		return mst;
	}

}
