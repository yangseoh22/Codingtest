import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());  // 온도 측정 수
		int K = Integer.parseInt(st.nextToken());  // 연속 날짜의 수
		
		// 온도 수열 입력
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for(int i=0; i<=N-K; i++) {
			sum = 0;
			for(int w=i; w<i+K; w++) {
				sum += arr[w];
			}
			max = Math.max(sum, max);
		}
		System.out.println(max);
	}

}
