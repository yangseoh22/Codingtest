/*
 * 시간 : 
 * 메모리 : 
 * 전략 : 
 * 
 */

import java.util.*;
import java.io.*;

public class Main {
	static int K;
	static int[] num, arr;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();

		while (true) {
			st = new StringTokenizer(br.readLine());
			if (st.countTokens() == 1)
				break; // 읽은 토큰이 1개(0)이면 종료

			K = Integer.parseInt(st.nextToken());
			num = new int[K];
			for (int i = 0; i < K; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}

			arr = new int[K];
			combi(0, 0);
			sb.append("\n");
		}

		System.out.println(sb);
	}

	private static void combi(int idx, int start) {
		if (idx == 6) {
			for (int i=0; i<6; i++) {
				sb.append(num[arr[i]]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i < K; i++) {
			arr[idx] = i;
			combi(idx + 1, i + 1);

		}
	}

}
