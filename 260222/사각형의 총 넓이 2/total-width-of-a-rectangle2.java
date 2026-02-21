import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] y1 = new int[n];
        int[] x2 = new int[n];
        int[] y2 = new int[n];
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
            y1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
            y2[i] = sc.nextInt();
        }
        
        final int OFFSET = 100;
        boolean[][] map = new boolean[100+OFFSET][100+OFFSET];
        
        for(int i=0; i<n; i++) {
        	for(int r=x1[i]+OFFSET; r<x2[i]+OFFSET; r++) {
        		for(int c=y1[i]+OFFSET; c<y2[i]+OFFSET; c++) {
            		map[r][c] = true;
            	}
        	}
        }
        
        int cnt = 0;
        for(int i=0; i<100+OFFSET; i++) {
        	for(int j=0; j<100+OFFSET; j++) {
            	if(map[i][j]) cnt++;
            }
        }
        
        System.out.println(cnt);
	}
}