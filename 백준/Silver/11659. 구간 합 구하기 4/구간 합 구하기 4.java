import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();  // 수의 개수
		int m =sc.nextInt();  // 합을 구할 횟수
		
		// 인덱스 1부터 넣어야 편리
		long[] sum = new long[n+1];  // 배열합 저장 배열
		
		// 문제에서 i가 1이면 1번부터 참조함을 주의
		for(int i=1; i<=n; i++) {
			sum[i] = sum[i-1] + sc.nextInt();
		}
		
		// 구간합 구하기
		for(int k=0; k<m; k++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			
			System.out.println(sum[j] - sum[i-1]);
		}	
	}
}