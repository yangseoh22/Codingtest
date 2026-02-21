import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int OFFSET = 1000;
		boolean[][] map = new boolean[1001 + OFFSET][1001 + OFFSET];

		int ax1 = sc.nextInt();
		int ay1 = sc.nextInt();
		int ax2 = sc.nextInt();
		int ay2 = sc.nextInt();
		
		int bx1 = sc.nextInt();
		int by1 = sc.nextInt();
		int bx2 = sc.nextInt();
		int by2 = sc.nextInt();
		
		// 직사각형 칠하기
		for (int r = ax1 + OFFSET; r < ax2 + OFFSET; r++) {
			for (int c = ay1 + OFFSET; c < ay2 + OFFSET; c++) {
				map[r][c] = true;
			}
		}
		
		// 덮어서 없애기
		for (int r = bx1 + OFFSET; r < bx2 + OFFSET; r++) {
			for (int c = by1 + OFFSET; c < by2 + OFFSET; c++) {
				map[r][c] = false;
			}
		}
		
		int minX = Integer.MAX_VALUE;
		int minY = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;
		int maxY = Integer.MIN_VALUE;
		for (int i = 0; i < 1001 + OFFSET; i++) {
			for (int j = 0; j < 1001 + OFFSET; j++) {
				if (map[i][j]) {
					minX = Math.min(minX, i);
					minY = Math.min(minY, j);
					maxX = Math.max(maxX, i+1);
					maxY = Math.max(maxY, j+1);
				}
					
			}
		}
		
		int area = 0;
		if(minX == Integer.MAX_VALUE || minY == Integer.MAX_VALUE || maxX == Integer.MIN_VALUE || maxY == Integer.MIN_VALUE )
			area = 0;
		else area = (maxX - minX) * (maxY - minY);

		System.out.println(area);
	}

}