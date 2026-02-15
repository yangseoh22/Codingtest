import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			int N = Integer.parseInt(br.readLine());

			// 나무 높이
			int[] heights = new int[N];
			
			int maxH = Integer.MIN_VALUE;

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				heights[i] = Integer.parseInt(st.nextToken());
				if (maxH < heights[i]) {  // 가장 높은 나무
					maxH = heights[i];
				}
			}
			
			int one = 0;  // 필요한 1일의 수
			int two = 0;  // 필요한 2일의 수
			
			for(int i=0; i<N; i++) {
				int diff = maxH - heights[i];  // 최대 높이와의 차이
				two += diff/2;
				one += diff%2;
			}
			
			while(true) {
				if(one + 1>=two) break;  // 1일짜리가 많을 때는 할 수 있는 게 없음
				else {  // 2일 짜리가 많을 때는 1일로 쪼개주기
					two -= 1;
					one += 2;
				}
			}
			
			// 필요한 일 수 세기
			int day = 0;
			if(one > two) {
				day = one *2 - 1;
			}
			else if(one == two) {
				day = one + two;
			}
			else {
				day = two * 2;
			}
			
			sb.append("#").append(t).append(" ").append(day).append("\n");
		}
		System.out.println(sb);
	}

}
