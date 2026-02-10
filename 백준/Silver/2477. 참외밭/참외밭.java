import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int K = Integer.parseInt(br.readLine());  //1제곱미터 당 참외 수확 수
		
		// 한 방향으로 최대 500갈 수 있으므로 최대 범위 -500~500
		int[][] map = new int[1000][1000];
		
		// 육각 꼭짓점 입력
		int x = 0;  // 시작점 (0, 0)
		int y = 0;
		
		int[] points = new int[6];  // 길이 저장
		int maxHeight = Integer.MIN_VALUE;
		int maxWidth = Integer.MIN_VALUE;
		int idxH = 0;
		int idxW = 0;
		for(int i=0; i<6; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			points[i] = Integer.parseInt(st.nextToken());
			
			// 큰 사각형의 가로/세로 찾기
			if(dir==3 || dir==4) {
				if(maxHeight<points[i]) {
					maxHeight = points[i];
					idxH = i;
				}
			}
			else {
				if(maxWidth<points[i]) {
					maxWidth = points[i];
					idxW = i;
				}
			}		
		}	
		
		// 작은 사각형의 가로 세로 찾기
		int smallH = Math.abs(points[(idxH-1+6)%6] - points[(idxH+1)%6]);
		int smallW = Math.abs(points[(idxW-1+6)%6] - points[(idxW+1)%6]);
		
		// 큰 사각형의 넓이 - 작은 사각형의 넓이
		int area = maxHeight*maxWidth - smallW*smallH;
		System.out.println(area * K);
	}

}

/**
7
4 50
2 160
3 30
1 60
3 20
1 100
**/