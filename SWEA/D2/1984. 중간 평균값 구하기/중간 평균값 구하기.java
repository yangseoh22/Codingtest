import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for(int t=1; t<=TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int[] nums = new int[10];
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			int sum = 0;
			for(int i=0; i<10; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
				
				sum += nums[i];  // 총합 계산
				
				// 최대값, 최솟값 갱신
				max = Math.max(max, nums[i]);
				min = Math.min(min, nums[i]);
			}
			
			// 최대, 최솟값 뺀 총합으로 평균 계산
			sum = sum - max - min;
			int result = (int) Math.round(sum/8.0);
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

}
