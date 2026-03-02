/*
 * 전략 : 백트래킹 - 조합
 * 1. 조합 후보가되는 숫자들을 오름차순 정렬
 * 2. 백트래킹 호출 - len : 순열 깊이, numIdx: 후보가 될 수를 가리키는 인덱스
 * 2-1. 기저 조건 : len이 M과 같다면 조합 출력 및 반환
 * 2-2. prev 변수 생성 : 같은 레벨에서 바로 전에 넣었던 수를 저장해둠
 * 2-3. 0부터 N-1까지의 순회로 인덱스로 사용 ->
 * 		현재 후보 숫자(nums[i])가 prev와 같지 않다면 중복되는 조합이 아님 ->
 * 		len을 1 증가시키고, 현재 넣은 수의 인덱스(i)로 재귀 호출
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb;
	static int N, M;
	static int[] nums;
	static ArrayList<Integer> arr;

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

		combi(0, 0);

		System.out.println(sb);
	}

	private static void combi(int len, int numIdx) {
		if (len == M) {
			for (int a : arr) {
				sb.append(a).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		int prev = -1;

		for (int i = numIdx; i < N; i++) {
			if (prev != nums[i]) {
				prev=nums[i];
				
				arr.add(nums[i]);
				combi(len + 1, i );
				arr.remove(arr.size() - 1);
			}
		}
	}

}
