import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] bingo;
	static boolean[][] checkMap;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 빙고판 채우기
		bingo = new int[5][5];
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 사회자의 숫자 외침
		boolean flag = false;  // 빙고 여부
		int callCnt = 0;
		int num = 0;
		checkMap = new boolean[5][5];
		for(int i=0; i<5; i++) {
			if(flag) break;
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				num = Integer.parseInt(st.nextToken());
				findNum(num);
				callCnt++;
				if(checking()>=3) {
					flag = true;
					break;
				}
			}
		}
		
		System.out.println(callCnt);
	}
	
	// 부른 숫자가 있는 칸 위치를 true
	private static void findNum(int n) {
		for(int r = 0; r<5; r++) {
			for(int c = 0; c<5; c++) {
				if(bingo[r][c] == n)
					checkMap[r][c] = true;
			}
		}
	}

	// 빙고 줄 확인
	private static int checking() {
		int cnt = 0;
		// 가로 세로 확인
		for(int r = 0; r<5; r++) {
			int garo = 0;
			int sero = 0;
			for(int c = 0; c<5; c++) {
				if(checkMap[r][c]) garo++;
				if(checkMap[c][r]) sero++;
			}
			
			// 5개 연속으로 있음 = 한 줄 빙고
			if(garo==5) cnt++;
			if(sero==5) cnt++;
		}
		
		// 대각선 확인
		if(checkMap[0][0]&&checkMap[1][1]&&checkMap[2][2]&&checkMap[3][3]&&checkMap[4][4]) cnt++;
		if(checkMap[0][4]&&checkMap[1][3]&&checkMap[2][2]&&checkMap[3][1]&&checkMap[4][0]) cnt++;
		
		return cnt;
	}

}
