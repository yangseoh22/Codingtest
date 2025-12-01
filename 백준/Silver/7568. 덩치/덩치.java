import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[][] tmp = new int[n][2];
		
		for(int i=0; i<n; i++) {
			tmp[i][0] = sc.nextInt();
			tmp[i][1] = sc.nextInt();
		}
		
		for(int i=0; i<n; i++) {
			// 기준이 되는 사람의 몸무게와 키
			int targetX = tmp[i][0];
			int targetY = tmp[i][1];
			
			int k = 0; // 자신보다 큰 덩치의 사람 수
			
			// 본인 제외 덩치 더 큰 사람의 수 구하기
			for(int j=0; j<n; j++) {
				if(i!=j) { 
					if(targetX<tmp[j][0] && targetY<tmp[j][1]) {
						k++;
					}
				}
			}
			
			System.out.print((k+1)+" ");
		}
	}

}
