import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] adj;
	static boolean[] V;
	static int[] dist;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		adj = new int[N+1][N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			adj[x][y] = z;
		}
		
		V = new boolean[N+1];
		dist = new int[N + 1];
		for(int i=1; i<=N; i++) {
			dist[i] = (int)1e9;
		}
		
		dist[1] = 0;
		
		for(int i=1; i<=N; i++) {
			int minIdx = -1;
			for(int j=1; j<=N; j++) {
				if(V[j]) {
					continue;
				}
				if(minIdx==-1 || dist[minIdx]>dist[j])
					minIdx = j;
			}
			
			V[minIdx] = true;
			
			for(int j=1; j<=N; j++) {
				if(adj[minIdx][j] == 0) continue;
				
				dist[j] = Math.min(dist[j], dist[minIdx]+adj[minIdx][j]);
			}
		}
		
		for(int i=1; i<=N; i++) {
			if(i==1) continue;
			System.out.println(dist[i]+" ");
		}
	}

}
