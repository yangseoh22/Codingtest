import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
	
		int count = 1;   // 본인만으로 가능하므로 1부터 시작
		
		// 투 포인터를 활용한 연속된 합 찾기
		int start = 1;
		int end = 1;
		int sum = 1;
		
		while(end != n) {
			if (sum == n) {
				count++;  // 카운트 증가
				end++;  // 끝 포인터 증가
				sum += end;  // 합에 끝 포인터 합
			}
			else if(sum>n) {
				sum -= start;  // 시작 포인터 빼기
				start++;  // 시작 포인터 증가
			}
			else {
				end++;  // 끝 포인터 증가
				sum += end;  // 합에 끝 포인터 합
			}
		}
		
		System.out.println(count);
	}
}