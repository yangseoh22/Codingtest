import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] A;
	static int N, M, cnt;
	static boolean[] V;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		A = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			A[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			A[x].add(y);
			A[y].add(x);
		}
		
		V = new boolean[N+1];
		cnt = 0;
		V[1] = true;
		DFS(1);
		
		System.out.println(cnt);
	}

	private static void DFS(int now) {
		for(int next : A[now]) {
			if(!V[next]) {
				V[next]=true;
				cnt++;
				DFS(next);
			}
		}
	}

}
