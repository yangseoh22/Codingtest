import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] person = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			person[i] = Integer.parseInt(st.nextToken());
		}
		
		// 모든 집이 선택될 경우를 확인
		int minDist = Integer.MAX_VALUE;
		for(int h=0; h<N; h++) {
			int dist = 0;
			for(int j=0; j<N; j++) {
				if(j==h) continue;
				// 다른 사람들의 소요 거리 합계
				dist += person[j] * (Math.abs(h-j));
			}
			minDist = Math.min(minDist, dist);  // 최소값 갱신
		}
		
		System.out.println(minDist);
	}

}