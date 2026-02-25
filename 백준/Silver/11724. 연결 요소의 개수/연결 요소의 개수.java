import java.io.*;
import java.util.*;

public class Main {

	static ArrayList<Integer>[] A;
	static boolean[] V;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		A = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			A[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			// 양방향
			A[u].add(v);
			A[v].add(u);
		}
		
		V = new boolean[N+1];
		
		int cnt = 0;
		for(int i=1; i<=N; i++) {
			if(!V[i]) {
				cnt++;
				DFS(i);
			}
		}
		
		System.out.println(cnt);
	}
	private static void DFS(int n) {
		
		if(V[n]) return;
		V[n] = true;
		
		for(int v : A[n]) {
			if(!V[v]) {
				DFS(v);
			}
		}
	}
	
	
}
