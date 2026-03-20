import java.io.*;
import java.util.*;

public class Main {
	// 남 -> 동 -> 북 -> 서 이동
	static int[] dr = {1, 0, -1, 0}; 
	static int[] dc = {0, 1, 0, -1}; 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int num = Integer.parseInt(br.readLine());
		
		int[][]	map = new int[N][N];
		
		int snail = N*N;
		int nowX = 0;
		int nowY = 0;
		int dir = 0;  // 남쪽
		while(true) {
			map[nowX][nowY] = snail;
			if(snail == 0) break;
			
			nowX += dr[dir];
			nowY += dc[dir];
			snail--;
			if(snail == 0) break;
			
			// 맵을 벗어나거나 이미 채워진 곳을 만나면 회전
			if(nowX<0 || nowY<0 || nowX>=N || nowY>=N || map[nowX][nowY] != 0) {
				nowX -= dr[dir];
				nowY -= dc[dir];
				dir = (dir + 1)%4;
				nowX += dr[dir];
				nowY += dc[dir];
			}
		}
		
		// 좌표 찾기
		int numX = -1;
		int numY = -1;
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				sb.append(map[r][c]).append(" ");
				if(map[r][c] == num) {
					numX = r+1;
					numY = c+1;
				}
			}
			sb.append("\n");
		}
		
		sb.append(numX).append(" ").append(numY);
		System.out.println(sb);
	}

}
