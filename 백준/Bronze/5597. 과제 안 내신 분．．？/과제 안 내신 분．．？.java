import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num[] = new int[31];

		// 과제 제출한 번호는 수 증가
		for (int i=0; i<28; i++) {
			num[sc.nextInt()]++;
		}
		
		// 현재 배열 중 값이 0인 인덱스 출력 (오름차순 접근)
		for (int i=1; i<=30; i++) {
			if(!(num[i]>0)) System.out.println(i);
		}
	}
}