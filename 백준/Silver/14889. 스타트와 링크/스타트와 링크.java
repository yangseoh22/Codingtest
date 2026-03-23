/*
 * 시간 : 
 * 메모리 : 
 * 전략 : 
 * 1. 
 */

import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int sum = 0;
	static int[][] S;
	static int[] arr, start, link, combArr;
	static boolean[] selected;
	static int minDiff = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		S = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		arr = new int[N];
		selected = new boolean[N];
		combi(0, 0);

		System.out.println(minDiff);
	}

	private static void combi(int idx, int start) {
		if (idx == N / 2) {
			calScore();
			return;
		}

		for (int i = start; i < N; i++) {
			arr[idx] = i;
			selected[i] = true;
			combi(idx + 1, i + 1);
			selected[i] = false;
		}
	}

	// 두 배열의 모든 쌍의 합의 차이
	private static void calScore() {
		int sScore = 0;
		int lScore = 0;
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				if(selected[i] && selected[j]) {
					sScore += S[i][j] + S[j][i];
				}
				else if(!selected[i] && !selected[j]) {
					lScore += S[i][j] + S[j][i];
				}
			}		
		}
		
		int tmp = Math.abs(sScore - lScore);
		minDiff = Math.min(minDiff, tmp);
	}

}
