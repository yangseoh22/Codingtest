import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		// 입력 받는 수들이 배열에 있는지 탐색
		for(int i=0; i<m; i++) {
			boolean exit = false;
			int target = Integer.parseInt(st.nextToken());
			
			int start = 0;  // 시작 인덱스
			int end = arr.length-1;  // 끝 인덱스
			
			while(start <= end ) {
				int mid_idx = (start+end)/2;
				int mid_value = arr[mid_idx];
				
				if(mid_value>target) {
					end = mid_idx-1;
				}
				else if (mid_value<target) {
					start = mid_idx+1;
				}
				else {
					exit = true;
					break;
				}
			}
			
			if(exit) System.out.println(1);
			else System.out.println(0);
		}
	}

}
