import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] code;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		code = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			code[i] = Integer.parseInt(st.nextToken());
		}

		// 학생 수
		int stdNum = Integer.parseInt(br.readLine());
		for (int i = 0; i < stdNum; i++) {
			st = new StringTokenizer(br.readLine());
			int nowStd = Integer.parseInt(st.nextToken());
			int nowNum = Integer.parseInt(st.nextToken());

			// 남학생
			if (nowStd == 1) {
				for (int m = nowNum - 1; m < N; m += nowNum) { // 받은 수 배수를 변환
					code[m] = Math.abs(code[m] - 1);

				}
				// sb.append("\n");
			} else if (nowStd == 2) { // 여학생
				switchGirl(nowNum-1); // 인덱스 접근이므로 1감소
			}
		}
		
		for (int i=0; i<N; i++) {
            sb.append(code[i]).append(" ");
			if((i+1)%20==0) {
				sb.append("\n");
			}
		}

		System.out.println(sb);
	}

	private static void switchGirl(int n) {
		int left = n;
		int right = n;

		while (left - 1 >= 0 && right + 1 < N) {
			if (code[left - 1] == code[right + 1]) {
				left--;
				right++;
			} else
				break;

		}

		for (int i = left; i <= right; i++) {
			code[i] = Math.abs(code[i] - 1);
		}
	}

}
