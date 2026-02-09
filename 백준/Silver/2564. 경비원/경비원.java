import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 블럭의 가로와 세로
		st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		// 상점 개수
		int N = Integer.parseInt(br.readLine());
		
		
		// 사각형 둘레를 한 줄로 펼친다면
		int[] map = new int[N+1];
		int tmp = 0;
		for(int i=0; i<N+1; i++) {
			// 상점의 위치와 동근이의 위치(마지막)
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int loc = Integer.parseInt(st.nextToken());
			
			if(dir == 1) {
				// idx 0 ~ w-1
				tmp = loc;
			}
			else if(dir == 4) {
				// idx w ~ w+h-1
				tmp = w + loc;
			}
			else if(dir == 2) {
				// idx w+h ~ 2w+h-1
				tmp = w + h + (w - loc);
			}
			else {
				// idx 2w+h ~ 2w+2h-1
				tmp = w + h + w + (h - loc);
			}
			
			map[i] = tmp;
		}
		
		int sum = 0;
		for(int i=0; i<N; i++) {
			// 각 상점과 동근이의 차이 중 최솟값을 합
			sum += Math.min(Math.abs(map[N]-map[i]), 2*(w+h)-Math.abs(map[N]-map[i]));
		}
		
		System.out.println(sum);
	}

}
