import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static boolean[] V;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		DFS(2, 1);
		DFS(3, 1);
		DFS(5, 1);
		DFS(7, 1);
		System.out.println(sb);
	}

	private static void DFS(int n, int jarisu) {

		if (jarisu == N) {
			if (isPrime(n))
				sb.append(n).append("\n");
			return;
		}


		// 다음 수 구하기 - 2, 4, 6, 8, 5가 오면 무조건 소수가 아니므로 제외
		for (int i = 1; i <= 9; i += 2) {
			if(i==5) continue;
			
			int newN = n * 10 + i;
			if (isPrime(newN)) {
				DFS(newN, jarisu + 1);
			}
		}

	}

	// 소수 판별
	private static boolean isPrime(int newN) {
		for (int i = 2; i*i<newN; i++) {
			if (newN % i == 0)
				return false;
		}
		return true;
	}

}
