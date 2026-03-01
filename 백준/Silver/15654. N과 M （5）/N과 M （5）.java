/*
 * 전략 : 백트래킹 - 순열
 * 1. 변수 입력, 리스트, 방문 배열 생성, 순열의 후보가 되는 수를 오름차순 정렬한 배열 생성
 * 2. 순열 백트래킹 함수 호출 - len: 현재 리스트(만든 순열)의 크기
 * 2-1. 기저 조건 : len이 M과 같다면, 수열 출력과 반환
 * 2-2. 수열의 수가 방문되지 않았다면, ( 리스트에 추가, 방문 표시 -> 
 * 		len+1로 재귀 호출 -> 리스트에서 삭제, 방문 취소 표시 ) 반복
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static ArrayList<Integer> arr;
	static int[] nums;
	static boolean[] V;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new ArrayList<>();

		V = new boolean[N];
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(nums);
		// 입력된 수열의 순열
		perm(0);

		System.out.println(sb);
	}

	private static void perm(int idx) {
		if (idx == M) {
			for (int a : arr) {
				sb.append(a).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) { // 인덱스로 수열을 접근
			if (!V[i]) {
				arr.add(nums[i]);
				V[i] = true;
				perm(idx + 1);
				arr.remove(arr.size() - 1);
				V[i] = false;
			}

		}
	}

}
