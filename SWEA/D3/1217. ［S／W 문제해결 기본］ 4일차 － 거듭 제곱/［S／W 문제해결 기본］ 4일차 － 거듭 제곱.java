import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t=0; t<10; t++) {
			
			int TC = sc.nextInt();  // 케이스 번호
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int result = squared(N, M);
			
			System.out.println("#" + TC + " " + result);
		}
	}

	private static int squared(int n, int m) {

		if(m == 0)
			return 1;
		
		return n * squared(n, m-1);
	}

}

