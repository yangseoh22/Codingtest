import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] A;
	static boolean[] V;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		A = new int[M];
		V = new boolean[N+1];
		
		perm(0);
		
		System.out.println(sb);
	}
	private static void perm(int len) {
		if(len==M) {
			printArr();
			return;
		}
		
		for(int i=1; i<=N; i++) {
			A[len] = i;
			perm(len + 1);
		}
		
		// 일반 순열
//		for(int i=1; i<=N; i++) {
//			if(!V[i]) {
//				A[len] = i;
//				V[i] = true;
//				perm(len + 1);
//				V[i] = false;
//			}
//		}
	}
	private static void printArr() {
		for(int a : A) {
			sb.append(a).append(" ");
		}
		sb.append("\n");
	}
	
	
}
