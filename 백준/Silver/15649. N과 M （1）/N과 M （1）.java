import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static int N, M;
	static int[] A;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[M];
		
		visited = new boolean[N+1];
		backtracking(0);
		
		System.out.println(sb);
	}

	private static void backtracking(int len) {
		if(len==M) {
			for(int i=0; i<M; i++) {
				sb.append(A[i]+1).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				A[len] = i;
				backtracking(len + 1);
				visited[i] = false;
			}
		}
	}

}
