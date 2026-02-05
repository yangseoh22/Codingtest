import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static int[][] gears;  // 자석 상태

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			sb.append("#").append(t).append(" ");

			int tc = Integer.parseInt(br.readLine()); // 현재 테케의 테스트 케이스 수

			// 자석 상태 입력 - n극이 0, s극이 1
			gears = new int[4][8];
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					gears[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 회전
			for (int i = 0; i < tc; i++) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken()) - 1; // 자석 번호
				int dir = Integer.parseInt(st.nextToken()); // 1: 시계, -1: 반시계
				
				int[] rotateDirs = new int[4];  // 회전할 방향을 미리 파악하기
			    rotateDirs[num] = dir;
				
			    // 왼쪽 자석의 회전 방향
			    for (int j = num - 1; j >= 0; j--) {
			        if (gears[j][2] != gears[j + 1][6]) {
			            rotateDirs[j] = -rotateDirs[j + 1];
			        } else {
			            break;
			        }
			    }
			    
			    // 오른쪽 자석의 회전 방향
			    for (int j = num + 1; j < 4; j++) {
			        if (gears[j][6] != gears[j - 1][2]) {
			            rotateDirs[j] = -rotateDirs[j - 1];
			        } else {
			            break;
			        }
			    }
			    
			    // 파악해둔 방향으로 회전
			    for (int j = 0; j < 4; j++) {
			        if (rotateDirs[j] == 1) {
			            rightRotate(gears, j);
			        } else if (rotateDirs[j] == -1) {
			            leftRotate(gears, j);
			        }
			    }

			}
			sb.append(calScore(gears)).append("\n");
		}
		System.out.println(sb);
	}

	// 자석을 시계방향 회전
	public static void rightRotate(int[][] arr, int num) {
		int tmp = arr[num][7];
		for (int i = 7; i > 0; i--) {
			gears[num][i] = arr[num][i - 1];
		}
		gears[num][0] = tmp;
	}
	
	// 자석을 반시계방향 회전
	public static void leftRotate(int[][] arr, int num) {
		int tmp = arr[num][0];
		for (int i = 0; i < 7; i++) {
			gears[num][i] = arr[num][i + 1];
		}
		gears[num][7] = tmp;
	}
	
	// 점수 계산
	private static int calScore(int[][] result) {
		int total = 0;
		
		for (int i = 0; i < 4; i++) {
			if(gears[i][0] == 1) {
				total += Math.pow(2, i);
			}
		}
		
		return total;
	}
}
