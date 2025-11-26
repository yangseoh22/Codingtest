import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();
		
		// 1~(n-1)번째 줄 : 1부터 n-2개까지 2개씩 증가
		for(int i=1; i<=n-1; i++) {
			for(int j=0; j<n-i; j++) {
				sb.append(" ");
			}
			for(int j=0; j<i*2-1; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		
		// n번째 줄 : n개 출력
		for(int i=0; i<2*n-1; i++) {
			sb.append("*");
		}
		sb.append("\n");
		
		// (n+1)~(2*n-1)번째 줄 :  n-2개부터 1개까지 2개씩 감소
		for(int i=n-1; i>=1; i--) {
			for(int j=0; j<n-i; j++) {
				sb.append(" ");
			}
			for(int j=0; j<i*2-1; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
