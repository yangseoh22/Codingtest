import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i=n; i>0; i--) {  // n에서 줄어들기
			for(int j=1; j<=n; j++) {  // 1부터 n까지 반복
				if(j>=i) System.out.print("*");
				else System.out.print(" ");
			}
			System.out.println();
		}
	}
}
