import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 숫자의 개수
		int n = sc.nextInt();
		
		// 숫자는 문자형 입력 - 최대 100자리 수 까지 가능하므로 정수형으로 불가
		String num = sc.next();
		char[] nums = num.toCharArray();
		
		int sum = 0;  // 합 변수
		for (int i=0; i<n; i++) {
			sum += nums[i] - '0';  // 누적 합
		}
	
		System.out.println(sum);
	}
}
