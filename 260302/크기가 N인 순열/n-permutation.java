import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static int N, M;
	static ArrayList<Integer> arr;
	static StringBuilder sb;
	static boolean[] V;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		arr = new ArrayList<>();
		V = new boolean[N+1]; // 방문 표시 배열
		
		// 1~N에서 하나씩 뽑는 순열
		perm(0);
		System.out.println(sb);
	}

	private static void perm(int idx) {
		if(idx == N) {
			for (int a : arr) {
				sb.append(a).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(!V[i]) {
				arr.add(i);
				V[i] = true;
				perm(idx + 1);
				arr.remove(arr.size()-1);
				V[i] = false;
			}
		}
	}
}
