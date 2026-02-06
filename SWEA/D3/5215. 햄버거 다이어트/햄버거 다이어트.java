import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, L, max;
	static int[][] arr;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=TC; t++) {
			sb.append("#").append(t).append(" ");
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			max = Integer.MIN_VALUE;
			
			arr = new int[N][2];
			isSelected = new boolean[N];
			
			// 재료, 칼로리 입력
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			bitmasking();
			
			// 부분 집합 찾기
			sb.append(max).append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static void bitmasking() {
		// 모든 부분 집합의 경우의 수 2^N
		for(int i=0; i<(1<<N); i++) {
			int totalScore = 0;
			int totalCal = 0;
			
			// i에 각 원소(j)가 포함되었는지 검사
			for(int j=0; j<N; j++) {
				// j번재 원소가 포함되었으면 합계
				if((i & (1<<j)) != 0) {
					totalScore += arr[j][0];
					totalCal += arr[j][1];
				}
			}
			// 총 칼로리가 L보다 작으면 최대 점수 갱신
			if(totalCal<L) {
				max = Math.max(totalScore, max);
			}
		}
	}

}
