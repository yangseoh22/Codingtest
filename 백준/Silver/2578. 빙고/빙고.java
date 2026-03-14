import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static int N, bingoCnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = 5;
		
		
		map = new int[N][N];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 0;
		boolean flag = false;
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				int mc = Integer.parseInt(st.nextToken()); // 사회자가 부른 숫자
				cnt++;

				// 빙고 확인
				flag = checking(mc);
				if(flag) break;
			}
			if(flag) {
				sb.append(cnt).append("\n");
				break;
			}
		}

		System.out.println(sb);
	}

	private static boolean checking(int target) {

		findNum(target);
		bingoCnt = 0;
		
		// 가로 검사
		int garo = 0;
		for (int r = 0; r < N; r++) {
			garo = 0;
			for (int c = 0; c < N; c++) {
				if (map[r][c] != 0)
					break;
				garo++;
			}
			if (garo == 5) bingoCnt++;
		}

		// 세로 검사
		int sero = 0;
		for (int c = 0; c < N; c++) {
			sero = 0;
			for (int r = 0; r < N; r++) {
				if (map[r][c] != 0)
					break;
				sero++;
			}
			if (sero == 5) bingoCnt++;
		}

		// 하향 대각선 검사
		int downD = 0;
		for (int r = 0; r < N; r++) {
			if (map[r][r] != 0)
				break;
			downD++;
		}
		if (downD == 5) bingoCnt++;

		// 상향 대각선 검사
		int upD = 0;
		for (int r = 0; r < N; r++) {
			if (map[4-r][r] != 0)
				break;
			upD++;
		}
		if (upD == 5) bingoCnt++;

		if(bingoCnt>=3) return true;
		else return false;
	}

	private static void findNum(int target) {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] == target) {
					map[r][c] = 0;
					return;
				}
			}
		}
	}

}
