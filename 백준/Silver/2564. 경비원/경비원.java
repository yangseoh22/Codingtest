import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		int n = Integer.parseInt(br.readLine());

		int[] dir = new int[n+1];
		int[] dist = new int[n+1];
		for (int i = 0; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			// 1: 북, 2: 남, 3: 서, 4: 동
			dir[i] = Integer.parseInt(st.nextToken());
			dist[i] = Integer.parseInt(st.nextToken());
		}

		int[] result = new int[n];
		
		int one=0, two=0, dongDist = 0;
		for (int i = n; i >=0; i--) {
			int tmp = 0;
			
			// 핵심 : 한 줄로 펼쳐졌다고 생각!
			if (dir[i] == 1) {
				tmp = dist[i];
			}
			else if(dir[i] == 4) {
				tmp = w + dist[i];
			}
			else if(dir[i] == 2) {
				tmp = w + h + (w - dist[i]);  // 기준점 유의
			}
			else {
				tmp = w + h + w + (h - dist[i]);  // 기준점 유의
			}
			
			if(i==n) dongDist = tmp;
			
			// 동근이가 아닐 때는 거리 계산
			if(i<n) {
				one = Math.abs(dongDist-tmp);  // 첫번째 방향
				two = 2*w + 2*h - one;  // 두번째 방향
				
				result[i] = one < two ? one : two;  // 더 작은 값으로 저장
			}
		}
		
		int sum = 0;
		for(int r : result) {
			sum += r;
		}
		sb.append(sum).append("\n");
		System.out.println(sb);
	}

}
