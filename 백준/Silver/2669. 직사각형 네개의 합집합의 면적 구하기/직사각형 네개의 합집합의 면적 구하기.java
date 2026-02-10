import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 사각형 좌표 입력 + 사각형 위치한 곳은 true로 변경
		map = new boolean[101][101];
		for(int i=0; i<4; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			setMap(x1, y1, x2, y2);
		}
		
		// 면적 구하기 -> true인 부분만 세기
		int area = 0;
		for(int r=0; r<=100; r++) {
			for(int c=0; c<=100; c++) {
				if(map[r][c]) area++;
			}
		}
		System.out.println(area);
	}

	private static void setMap(int x1, int y1, int x2, int y2) {
		for(int r=x1; r<x2; r++) {
			for(int c=y1; c<y2; c++) {
				map[r][c] = true;
			}
		}
	}

}
