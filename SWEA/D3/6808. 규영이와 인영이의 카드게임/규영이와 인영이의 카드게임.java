import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static boolean[] isGyuUsed;
	static int[] gyu;
	static int[] iny;
	static int winCnt;
	static int loseCnt;
	static boolean[] isInyUsed;
	static int[] permResult;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for(int t=1; t<=TC; t++) {
			sb.append("#").append(t).append(" ");
			
			isGyuUsed = new boolean[19];  // 규영이한테 있는 것
			gyu = new int[9];  // 규영이 카드(순서대로 냄)
			iny = new int[9];  // 인영이 카드(숫자만 나열)
			winCnt = 0;  // 규영의 승리 수
			loseCnt = 0;  // 규영의 패배 수
			isInyUsed = new boolean[9];  // 인영 순열에 쓴 카드
			permResult = new int[9];  // 인영의 순열
			
			st = new StringTokenizer(br.readLine());
			// 규영이의 카드
			for(int i=0; i<9; i++) {
				gyu[i] = Integer.parseInt(st.nextToken());
				isGyuUsed[gyu[i]] = true;
			}
			
			// 인영이의 카드
			int idx = 0;
			for(int i=1; i<=18; i++) {
				if(!isGyuUsed[i]) iny[idx++] = i;
			}
			
			perm(0);  // 순열 돌리기
			
			sb.append(winCnt).append(" ").append(loseCnt).append("\n");
		}
		System.out.println(sb);
	}
	
	static void perm(int cnt) {
		if(cnt == 9) {
			//점수 카운팅
			gyuWin();
			return;
		}
		
		for(int i=0; i<9; i++) {
			if(!isInyUsed[i]) {
				permResult[cnt] = iny[i];
				isInyUsed[i] = true;
				perm(cnt+1);
				isInyUsed[i] = false;
			}
		}
	}

	static void gyuWin() {
		int gyuCnt = 0;
		int inyCnt = 0;
		for(int i=0; i<9; i++) {
			// 더 큰 수를 낸 사람이 두 수의 합을 점수로 획득
			if(gyu[i] > permResult[i]) gyuCnt += (gyu[i] + permResult[i]);
			else inyCnt += (gyu[i] + permResult[i]);
		}
		
		// 규영이 점수가 더 높으면 승리, 아니면 패배
		if(gyuCnt>inyCnt) winCnt++;
		else loseCnt++;
	}
}
