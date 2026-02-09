import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());  // 숫자 수
		
		st = new StringTokenizer(br.readLine());
		int[] num = new int[N];
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int maxCnt = 1;
		
		// 오름차순 확인
		int cnt = 1;
		for(int i=0; i<N-1; i++) {
			// 연속된 상황
			if(num[i] <= num[i+1]) {
				cnt++;
				maxCnt = Math.max(maxCnt, cnt);
			}
			else{  // 연속이 끊김
				maxCnt = Math.max(maxCnt, cnt);
				cnt = 1;
			}
		}
		
		// 내림차순 확인
		cnt = 1;
		for(int i=0; i<N-1; i++) {
			// 연속된 상황
			if(num[i] >= num[i+1]) {
				cnt++;
				maxCnt = Math.max(maxCnt, cnt);
			}
			else{  // 연속이 끊김
				maxCnt = Math.max(maxCnt, cnt);
				cnt = 1;
			}
		}
		
		System.out.println(maxCnt);
	}

}
