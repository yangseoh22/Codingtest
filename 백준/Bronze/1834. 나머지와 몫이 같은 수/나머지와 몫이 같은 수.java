import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long n = sc.nextInt();
		long sum = 0;
		
		long q=1;  // 몫이자 나머지가 될 수
		
		// 문제 조건을 만족하는 수만 덧셈
		// 몫이 본인보다 크면 만족할 수 없음
		while(n>q) {
			sum += n*q + q;
			q++;
		}
		
		System.out.println(sum);
	}

}
