import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();
		
		int[][] tmp = new int[n][2];
		
		// 좌표 입력
		for(int i=0; i<n; i++) {
			tmp[i][0] = sc.nextInt();
			tmp[i][1] = sc.nextInt();
		}
		
		// 정렬
		Arrays.sort(tmp, (e1, e2) -> {
			// x좌표가 같으면 y좌표 기준 오름차순 정렬
			if(e1[0]==e2[0]) return e1[1] - e2[1];
			
			// x좌표 기준 오름차순 정렬
			else return e1[0] - e2[0];
		});
		
		// 출력
		for(int i=0; i<n; i++) {
			sb.append(tmp[i][0]).append(" ").append(tmp[i][1]).append('\n');
		}
		System.out.println(sb);
	}

}
