import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(st.nextToken());  // 데이터 수
		int N = Integer.parseInt(st.nextToken());  // 질의 수
		int[] arr = new int[M];
		
		// 배열 입력
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 구간합 배열 생성
		int[] sum = new int[M+1];
		sum[0] = 0;  // 첫번째 요소로 초기화
		for(int i=1; i<=M; i++) {
			sum[i] = sum[i-1] + arr[i-1];
		}
		
		// 질의 받고 start에서 end의 합 반환
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			sb.append(sum[end]-sum[start-1] + "\n");
		}
		
		System.out.println(sb);
	}
}
