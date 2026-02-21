import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ax1 = sc.nextInt();
		int ay1 = sc.nextInt();
		int ax2 = sc.nextInt();
		int ay2 = sc.nextInt();
		int bx1 = sc.nextInt();
		int by1 = sc.nextInt();
		int bx2 = sc.nextInt();
		int by2 = sc.nextInt();
		int mx1 = sc.nextInt();
		int my1 = sc.nextInt();
		int mx2 = sc.nextInt();
		int my2 = sc.nextInt();

		final int OFFSET = 1000;
		boolean[][] map = new boolean[1000 + OFFSET][1000 + OFFSET];

		for (int r = ax1 + OFFSET; r < ax2 + OFFSET; r++) {
			for (int c = ay1 + OFFSET; c < ay2 + OFFSET; c++) {
				map[r][c] = true;
			}
		}
		
		for (int r = bx1 + OFFSET; r < bx2 + OFFSET; r++) {
			for (int c = by1 + OFFSET; c < by2 + OFFSET; c++) {
				map[r][c] = true;
			}
		}
		
		for (int r = mx1 + OFFSET; r < mx2 + OFFSET; r++) {
			for (int c = my1 + OFFSET; c < my2 + OFFSET; c++) {
				map[r][c] = false;
			}
		}
		int cnt = 0;
		for (int i = 0; i < 1000 + OFFSET; i++) {
			for (int j = 0; j < 1000 + OFFSET; j++) {
				if (map[i][j])
					cnt++;
			}
		}
}