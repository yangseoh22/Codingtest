import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = 10;
		
		for(int test_case=1; test_case<=T; test_case++) {
			
			sb.append("#"+test_case+" ");
			
			// 테케 번호
			int n = Integer.parseInt(br.readLine());
			
			int[] arr = new int[8];
			st = new StringTokenizer(br.readLine());
			
			// 배열 입력
			for(int i=0; i<8; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			
			int now = 0;
			boolean flag = false;  // 암호 사이클을 종료할지
			while(true){
				// 암호 사이클
				for(int i=1; i<=5; i++) {
					now = arr[0] - i;  // 첫번째 요소를 i만큼 감소
					
					// 사이클 돌린 요소가 0이하이면 중지
					if(now<=0) { 
						arr = changeArr(arr, 0);
						flag = true;
						break;
					}
					
					arr = changeArr(arr, now);
				}
				
				if(flag) break;  // 사이클 중지
			}
			
			for(int i=0; i<8; i++) {
				sb.append(arr[i] + " ");
			}
			
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static int[] changeArr(int[] arr, int now) {
		int[] code = new int[8];
		
		// 마지막 요소 전까지 왼쪽으로 shift
		for(int i=0; i<8-1; i++) {
			code[i] = arr[i+1];
		}
		
		// 마지막 요소는 바뀐 값으로
		code[7] = now;
		
		return code;
	}

}
