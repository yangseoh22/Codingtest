import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// 시계 방향 회전 : 상 -> 우 -> 하 -> 좌
	static int[] dc = { 0, 1, 0, -1 };
	static int[] dr = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] map = new int[C + 1][R + 1];

		int K = Integer.parseInt(br.readLine());
		
		if (K > C*R) {  // 배정 가능 수가 불가능하면 종료
			System.out.println(0);
			return;
		}
		else {
			int seatNum = 1;
			int x = 1;
			int y = 1;
			int dir = 0;
			map[x][y] = seatNum++;  // 첫 요소 넣기
			
			if(K==1) {
				System.out.println(x + " " + y);
				return;
			}
			
			for(int i=0; i<C*R; i++) {
				int newX = x + dc[dir];
				int newY = y + dr[dir];

				// 좌석 범위 내에 있으며, 아직 번호를 매기지 않은 자리라면 좌석 배정
				if (newX >= 1 && newY >= 1 && newX <= C && newY <= R && (map[newX][newY] == 0)) {
					x = newX;
					y = newY;
					map[x][y] = seatNum++;
				} else {
					// 방향 변경하기
					dir = (dir + 1) % 4;
					newX = x + dc[dir];
					newY = y + dr[dir];

					// 좌석 범위 내에 있으며, 아직 번호를 매기지 않은 자리라면 좌석 배정
					if (newX >= 1 && newY >= 1 && newX <= C && newY <= R && (map[newX][newY] == 0)) {
						x = newX;
						y = newY;
						map[x][y] = seatNum++;
					}
				}
				
				// 현재 배정된 좌석 수가 K라면 종료
				if (seatNum - 1 == K)
					break;
			}
			
			System.out.println(x + " " + y);
		}
		
	}

}
