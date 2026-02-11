import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb  = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			
			// A 딱지의 그림 수와 종류
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int[] arrA = new int[5];
			for (int x = 0; x < a; x++) {
				int tmp = Integer.parseInt(st.nextToken());
				arrA[tmp]++;
			}

			// B 딱지의 그림 수와 종류
			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());
			int[] arrB = new int[5];
			for (int y = 0; y < b; y++) {
				int tmp = Integer.parseInt(st.nextToken());
				arrB[tmp]++;
			}
			
			// 딱지의 그림 비교
			boolean flag = false;  // 승부 판정 여부
			for(int t=4; t>0; t--) {
				if(arrA[t]>arrB[t]) {
					sb.append("A");  // A 승리
					flag = true;;
					break;
				}
				else if(arrA[t]<arrB[t]){
					sb.append("B");  // B 승리
					flag = true;
					break;
				}
			}
			
			// 무승부일 경우
			if(!flag) sb.append("D");
			
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
