import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();  // 주어진 수
		int cnt = 1;  // 현재 방 개수 중 최대 번호
		int r = 1;  //현재 지나야 할 방 개수

		while(n>cnt) {  // 현재 방 개수 중 최대번호 보다 주어진 수가 작을 때까지 반복
			cnt += r*6;  // 최대 번호 = 지나야할 방 개수 * 6의 누적합
			r++;  // 방 개수 증가
		}
		System.out.println(r);
	}
}