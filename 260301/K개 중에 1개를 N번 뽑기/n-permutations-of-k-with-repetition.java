import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int K, N;
	static ArrayList<Integer> arr;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		arr = new ArrayList<>();
		
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		perm(0);
		
		System.out.println(sb);
	}

	private static void perm(int idx) {
		if(idx == N) {
			for(int a : arr) {
				sb.append(a).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<=K; i++) {
			arr.add(i);
			perm(idx + 1);
			arr.remove(arr.size()-1);
		}
	}

}
