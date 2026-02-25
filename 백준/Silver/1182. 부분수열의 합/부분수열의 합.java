import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int N, S, cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		cnt = 0;
		backtracking(0, 0);

		// 부분 수열의 길이를 전달
		sb.append(cnt);

		System.out.println(sb);
	}

	private static void backtracking(int start, int curSum) {
		
		// 부분 수열의 크기가 N이 되면 종료
		if (start == N) return;

		// 조합 구하기
		for (int i = start; i < N; i++) {
			if (curSum + arr[i] == S)
				cnt++;

			backtracking(i + 1, curSum + arr[i]);
		}

	}

}
