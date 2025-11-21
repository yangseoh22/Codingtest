import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, L;
	static int scores[];
	static int cals[];
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());  // 재료 수
			L = Integer.parseInt(st.nextToken());  // 제한 칼로리
			max = 0;
			
			scores = new int[N];
			cals = new int[N];
			
			// 재료별 맛과 칼로리
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				scores[i] = Integer.parseInt(st.nextToken());  // 맛
				cals[i] = Integer.parseInt(st.nextToken());  // 칼로리
			}
			
			DFS(0, 0, 0);
			System.out.printf("#%d %d\n", test_case, max);
		}
	}

	// idx : 현재 비교할 재료 번호
	// sc : 지금가지 선택한 재료들의 맛 점수 합
	// cal : 지금가지 선택한 재료들의 칼로리  합
	private static void DFS(int idx, int sc, int cal) {
		
		// 가지치기 (칼로리 합이 L을 넘으면 종료
		if(cal>L) return;
		
		// 모든 재료를 다 봤으면 종료
		if(idx==N) {
			// 현재 칼로리합이 최대값보다 크면 갱신
			max = Math.max(max, sc);
			return;
		}
		
		// 현재 재료를 햄버거에 넣는 경우
		DFS(idx+1, sc+scores[idx], cal+cals[idx]);
		
		// 현재 재료를 햄버거에 안넣는 경우
		DFS(idx+1, sc, cal);
	}

}
