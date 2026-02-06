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
			
			makeSubSet(0,0);
			
			// 조합 찾기
			sb.append(max).append("\n");
		}
		
		System.out.println(sb);
	}
	
	// cnt: 재귀의 깊이, pickCnt : 부분 집합에 들어가는 원소 수
	private static void makeSubSet(int cnt, int pickCnt){

		if(cnt == N) {
			int totalScore = 0;
			int totalCal = 0;
			
			for(int i=0; i<N; i++) {
				// 선택된 조합의 점수와 칼로리 계산
				if(isSelected[i]) {
					totalScore += arr[i][0];
					totalCal += arr[i][1];
				}
			}
			
			// 공집합이 아니면서 L칼로리 이하인 조합일 경우, 점수의 최대값 갱신
			if(pickCnt>0 && totalCal<L) {
				max = Math.max(totalScore, max);
			}
			
			return;
		}
		
		// 원소를 선택할 경우
		isSelected[cnt] = true;
		makeSubSet(cnt+1, pickCnt+1);
		
		// 원소를 선택하지 않은 경우
		isSelected[cnt] = false;
		makeSubSet(cnt+1, pickCnt);
	}

}
