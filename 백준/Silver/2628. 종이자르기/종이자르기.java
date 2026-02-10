import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		
		int N = Integer.parseInt(br.readLine());  // 자를 횟수
		
		boolean[] arrW = new boolean[width+1];
		boolean[] arrH = new boolean[height+1];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			// 가로 방향 자른 위치 저장
			if(dir==0) {
				arrH[num] = true;  // 세로가 잘릴 것이므로
			}
			// 세로 방향 자른 위치 저장
			else {
				arrW[num] = true;  // 가로가 잘릴 것이므로
			}
		}
		
		ArrayList<Integer> tmpW = new ArrayList<>();
		int prev = 0;
		for(int i=0; i<=width; i++) {
			if(arrW[i]) {
				tmpW.add(i-prev);  // 전에 자른 위치와 다음 자른 위치의 차이 저장
				prev = i;
			}
		}
		tmpW.add(width - prev);
		ArrayList<Integer> tmpH = new ArrayList<>();
		prev = 0;
		for(int i=0; i<=height; i++) {
			if(arrH[i]) {
				tmpH.add(i-prev);  // 전에 자른 위치와 다음 자른 위치의 차이 저장
				prev = i;
			}
		}
		tmpH.add(height - prev);
		
		int max = Integer.MIN_VALUE;
		for(int w = 0; w<tmpW.size(); w++) {
			for(int h = 0; h<tmpH.size(); h++) {
				int area = tmpW.get(w) * tmpH.get(h);
				max = Math.max(max, area);
			}
		}
		
		System.out.println(max);
	}

}
