/*
 * 전략 : 백트래킹 - 중복 조합
 * 1. 변수 입력, 리스트 생성, 조합의 후보가 되는 수를 오름차순 정렬한 배열 생성
 * 2. 조합 백트래킹 함수 호출 - len: 현재 리스트(만든 순열)의 크기, 
 * 		num : 이번에 넣을 수 있는 범위의 첫번 째 인덱스
 * 2-1. 기저 조건 : len이 M과 같다면, 수열 출력과 반환
 * 2-2. num부터 N까지의 수를 순회하며 ( 리스트에 추가 -> 
 * 		len+1, i(조합에 추가한 수의 인덱스)로 재귀 호출 -> 리스트에서 삭제 ) 반복
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
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new ArrayList<>();

		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(nums);
		// 입력된 수열의 조합
		combi(0, 0);  // num은 인덱스를 가리키는 것

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

		for (int i = num; i < N; i++) { // 인덱스로 수열을 접근
			arr.add(nums[i]);
			combi(idx + 1, i);
			arr.remove(arr.size() - 1);

		}
	}

}
