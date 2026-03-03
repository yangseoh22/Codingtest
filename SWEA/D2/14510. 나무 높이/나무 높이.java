import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {

			int N = Integer.parseInt(br.readLine());

			int[] trees = new int[N];
			int maxH = Integer.MIN_VALUE;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				trees[i] = Integer.parseInt(st.nextToken());
				maxH = Math.max(maxH, trees[i]); // 최대 나무 높이
			}
			
			// 최대 높이와의 차이와 필요한 2일의 수, 1일의 수 계산
			int one = 0;
			int two = 0;
			for (int t : trees) {
				int diff = maxH - t;

				two += diff / 2;
				one += diff % 2;
			}
			
			// 둘의 차이가 1보다 크면 재분배
			while (one+1<two) {  
				two--;
				one+=2;
			}

			// 물을 주어야 할 날 계산
			int day = 0;

			if (one > two)
				day = one * 2 - 1;
			else if (one <= two)
				day = two * 2;

			sb.append("#").append(tc).append(" ").append(day).append("\n");

		}
		System.out.println(sb);
	}

}
