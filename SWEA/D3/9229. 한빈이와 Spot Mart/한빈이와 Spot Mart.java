import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			sb.append("#").append(t).append(" ");

			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // 과자 개수
			int M = Integer.parseInt(st.nextToken()); // 최대 무게 합
			int[] snack = new int[N];

			// 과자 무게 입력
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				snack[i] = Integer.parseInt(st.nextToken());
			}

			int start = 0;
			int end = N - 1;
			int sum = 0;
			int max = Integer.MIN_VALUE;
			boolean isBuy = false;

			Arrays.sort(snack);  // 오름차순 정렬
			
			// 투포인터
			while (start < end) {
				sum = snack[start] + snack[end];
				if (sum <= M) {
					max = Math.max(max, sum);
					start++;
					isBuy = true;
				} else {
					end--;
				}
			}

			if (!isBuy) {
				sb.append(-1).append("\n");
			}
			else {
				sb.append(max).append("\n");
			}
				
		}
		System.out.println(sb);
	}

}
