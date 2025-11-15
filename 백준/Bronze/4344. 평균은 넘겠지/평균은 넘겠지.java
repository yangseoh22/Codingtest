import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t= sc.nextInt();  // 테스트 케이스 수
		
		for(int i=0; i<t; i++) {
			int n = sc.nextInt();  // 학생 수
			int sum = 0;  // 합계
			int tmp[] = new int[n];  // 점수 보관
			
			for(int j=0; j<n; j++) {
				tmp[j] = sc.nextInt();  // 점수 입력
				sum += tmp[j];  // 총 점수 합
			}
			
			double avg = sum/(double)n;  // 평균 계산

			int cnt = 0;  // 평균 넘는 학생 수
			for(int k=0; k<n; k++) {
				if (tmp[k]>avg) cnt++;
			}
			
			// 평균 넘는 학생 비율(소수점 3번째 자리에서 반올림) 출력
			// 비율 계산을 1000을 곱한 채로 반올림 했다가, 그 결과를 다시 1000.0으로 나눔
			System.out.println(Math.round(cnt/(double)n*100*1000)/1000.0 + "%");
		}
	}
}
