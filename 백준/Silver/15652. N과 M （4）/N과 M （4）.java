import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] A;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[M];
		
		combi(1, 0);
		
		System.out.println(sb);
	}
	private static void combi(int start, int len) {
		if(len==M){
			printArr();
			return;
		}
		
		// 중복 조합이므로 썼던 거(i) 또 써도 됨
		for(int i=start; i<=N; i++) {
			A[len] = i;
			combi(i, len + 1);
		}
	}
	private static void printArr() {
		for(int a : A) {
			sb.append(a).append(" ");
		}
		sb.append("\n");
	}

}
