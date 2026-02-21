import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int OFFSET = 100;
		int[][] map = new int[100 + OFFSET][100 + OFFSET];

		int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            
            for (int r = x1 + OFFSET; r < x2 + OFFSET; r++) {
    			for (int c = y1 + OFFSET; c < y2 + OFFSET; c++) {
    				// 빨간색 : 1, 파란색 : 2
    				// 짝수 차례에는 빨강, 홀수 차례에는 파랑 넣기
    				if(i%2==0) {
    					map[r][c] = 1;
    				}
    				else {
    					map[r][c] = 2;
    				}
    			}
    		}
            
        }
        
        // 파란색(2) 개수 세기
		int cnt = 0;
		for (int i = 0; i < 100 + OFFSET; i++) {
			for (int j = 0; j < 100 + OFFSET; j++) {
				if (map[i][j] == 2)
					cnt++;
			}
		}

		System.out.println(cnt);
	}
}