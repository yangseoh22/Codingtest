import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[100];
		
		int cnt = 0;  // 수열 길이  
		int max = Integer.MIN_VALUE;
		int idx = 0;  // 최대 개수를 얻은 두 번째 요소
		
		// 두 번째 수는 양의 정수 중 하나
		for(int i=N; i>0; i--) {
			
			// 첫 번째 수, 두 번째 수 넣기
			arr[0] = N;
			arr[1] = i;
			cnt = 2; // 배열 요소 개수 (이미 첫 번째 수와 두 번째 수가 들어가있음)
			
			// 세 번째부터 이후의 수는 모든 앞의 앞의 수에서 앞의 수를 뺌
			while(true) {
				int tmp = arr[cnt-2] - arr[cnt-1];
				
				if(tmp<0) break;  // 음수가 되면 종료
				
				arr[cnt] = tmp;
				cnt++;
			}
			
			// 최대 개수 구하기
			if(max<cnt) {
				max = cnt;
				idx = i;
			}
		}
		
		// 수열의 최대 개수 출력
		sb.append(max).append("\n");
		
		// 찾은 두 번째 숫자를 가지고 수열을 다시 생성 -> 출력
		arr = new int[max];
		arr[0] = N;
		arr[1] = idx;
		sb.append(arr[0]).append(" ").append(arr[1]).append(" ");
		
		for(int i=2; i<max; i++) {
			arr[i] = arr[i-2] - arr[i-1];
			
			if(arr[i]<0) break;
			else sb.append(arr[i]).append(" ");		
		}
		
		System.out.println(sb);
	}

}
