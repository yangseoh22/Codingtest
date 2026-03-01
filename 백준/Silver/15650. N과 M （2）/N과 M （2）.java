/* 
 * 전략 : 백트래킹 - 조합
 * 1. 입력 받을 것 받고, arrayList 생성
 * 2. 조합 재귀 함수 호출 - len : 현재 선택된 수열의 숫자 수, num : 최근에 넣은 수의 다음 수
 * 2-1. 기저 조건 :  len이 M과 같다면, 수열 출력 및 반환
 * 2-2. num부터 N까지의 수를 수열에 추가 -> len+1, i(현재 넣은 수)로 재귀 호출
 *  */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static ArrayList<Integer> arr;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken()); 
		
		arr = new ArrayList<>();
		
		combi(0, 1);
		
		System.out.println(sb);
	}
	
	private static void combi(int idx, int num) {
		if(idx == M) {
			for(int a : arr) {
				sb.append(a).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=num; i<=N; i++) {
				arr.add(i);  // 배열은 arr[idx] = i;
				combi(idx + 1, i + 1);
				arr.remove(arr.size()-1);
		}
	}

}
