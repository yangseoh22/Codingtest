import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());  // 참가 학생 수
		int K = Integer.parseInt(st.nextToken());  // 한 방에 배정 가능한 최대 인원 수
		
		int[][] student = new int[6][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());  // 성별 - 0:여학생 / 1:남학생
			int Y = Integer.parseInt(st.nextToken()) - 1;  // 학년(인덱스 때문에 1감소)
			
			student[Y][S]++;  // 입력 받은 학년/성별의 수를 증가
		}
		
		int cnt = 0;
		for(int y=0; y<6; y++) {
			for(int s=0; s<2; s++) {
				// K로 나누어 떨어지면 몫만큼 증가
				if(student[y][s]%K==0) {
					cnt += student[y][s]/K;
				}
				// 그렇지 않으면 몫+1만큼 증가
				else {
					cnt += student[y][s]/K + 1;
				}
			}
		}
		
		System.out.println(cnt);
	}

}
