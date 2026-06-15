import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t=0; t<10; t++) {
			
			int TC = sc.nextInt();  // 케이스 번호
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int result = squared(N, M, 1);
			
			System.out.println("#" + TC + " " + result);
		}
	}

	private static int squared(int n, int m, int num) {
		
		num *= n;
		
		if(m <= 1)
			return num;
		
		return squared(n, m-1, num);
	}

}

