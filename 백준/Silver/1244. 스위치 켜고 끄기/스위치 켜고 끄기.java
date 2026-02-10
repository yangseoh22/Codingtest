import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] switches;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		// 스위치 상태 입력 받기 - 1: 켜짐 / 0: 꺼짐
		switches = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			switches[i] = Integer.parseInt(st.nextToken());
		}

		// 학생 수와 학생 성별, 받은 수
		int std = Integer.parseInt(br.readLine());
		for (int i = 0; i < std; i++) {
			st = new StringTokenizer(br.readLine());
			int gen = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());

			if (gen == 1) { // 남학생이라면
				for (int s = 0; s < n; s++) {
					// 스위치 번호가 num의 배수인 곳을 switch
					if ((s + 1) % num == 0)
						switches[s] = 1 - switches[s];
				}
			} else if (gen == 2) { // 여학생이라면
				// num을 기준으로 양쪽의 대칭이 맞는 곳 까지 switch
				girlSwitch(num);
			}
		}

		// 최종 스위치 상태 출력 - 20개마다 줄 바꾸기
		for(int i=0; i<n; i++) {
			System.out.print(switches[i] + " ");
			if((i+1)%20==0) System.out.println();
		}
	}

	private static void girlSwitch(int num) {
		
		int left = num-1;  // 왼쪽 스위치 번호
		int right = num+1;  // 오른쪽 스위치 번호
		int range = 0;  // num 기준 양 옆으로 대칭인 개수
		
		while(true) {
			if(left>=1 && right<=n) {
				if(switches[left-1] == switches[right-1]) {
					range++;
					left--;
					right++;
				}
				else break;
			}
			else break;
		}
		
		// range범위 switch
		int start = num - range - 1;  // 인덱스라 1 빼주기
		int end = num + range -1;
		for(int i=start; i<=end; i++) {
			switches[i] = 1 - switches[i];
		}		
	}
}
