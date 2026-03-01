import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static ArrayList<Integer> arr;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new ArrayList<>();

		// 1~N에서 M개 뽑는 조합
		combi(0, 1);
		System.out.println(sb);
	}

	private static void combi(int idx, int num) {
		if (idx == M) {
			for (int a : arr) {
				sb.append(a).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = num; i <= N; i++) {
			arr.add(i);
			combi(idx + 1, i + 1);
			arr.remove(arr.size() - 1);
		}
	}

}
