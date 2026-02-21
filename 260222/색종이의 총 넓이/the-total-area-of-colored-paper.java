import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int OFFSET = 100;
        boolean[][] map = new boolean[101+OFFSET][101+OFFSET];
        
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            for (int r = x; r < x+8; r++) {
                for (int c = y; c < y+8; c++) {
                    map[r+OFFSET][c+OFFSET] = true;
                }
            }
            
        }
        
        int area = 0;
        for (int r = 0; r < 101+OFFSET; r++) {
            for (int c = 0; c < 101+OFFSET; c++) {
                if(map[r][c]) area++;
            }
        }
        System.out.println(area);
    }
}