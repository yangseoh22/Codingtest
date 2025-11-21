import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = 10;
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
            st = new StringTokenizer(br.readLine());
			int stop = Integer.parseInt(st.nextToken());
			int[] box = new int[100];  // 상자줄은 100개
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<100; i++) {
				box[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(box);
			
			int dump = 0;  // 덤프 횟수
			int min = 0 ;  // 최소값 위치
			int max = 99;  // 최대값 위치
			for(int i=0; i<stop; i++) {
				box[min]++;
				box[max]--;
				dump++;
				Arrays.sort(box);
				
				if(box[max]-box[min] <= 1) break;
			}
			
			System.out.printf("#%d %d\n", test_case, box[max]-box[min]);
		}
		
	}
}
