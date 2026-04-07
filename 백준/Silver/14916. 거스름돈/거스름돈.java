import java.io.*;
import java.util.Arrays;

public class Main {
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		dp = new int[n + 1];
		Arrays.fill(dp, -1);

		int result = solve(n);

		System.out.println(result == 100001 ? -1 : result);
	}

	private static int solve(int n) {
		if (n == 0) return 0;
		if (n < 0) return 100001;

		// 메모이제이션
		if (dp[n] != -1) return dp[n];
		
		// 5원으로 하는 경우, 2원으로 하는 경우 중 더 적은 횟수 저장
		int cnt = Math.min(solve(n - 5), solve(n - 2));
		
		if(cnt==100001) return dp[n] = cnt;

		return dp[n] = cnt + 1;
	}

}
