import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 과목의 개수
		int n = sc.nextInt();
		int[] score = new int[n];
		
		double max = 0;  // 최대값
		
		for (int i=0; i<n; i++) {
			int tmp = sc.nextInt(); 
			score[i] = tmp;  // 점수 입력
			
			if (max < tmp) max = tmp;
		}
		
		// 점수 변환 및 평균 계산
		double sum = 0;
		for (int i=0; i<n; i++) {
			sum += (score[i]/max)*100.0;
		}
		
		System.out.println(sum/n);
	}
}