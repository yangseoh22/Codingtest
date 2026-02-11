import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());  // 색종이 수
		int[][] map = new int[1001][1001];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());  // 시작 좌표
			int b = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());  // 색종이의 너비
			int height = Integer.parseInt(st.nextToken());  // 색종이의 높이
			
			// 입력 받은 좌표로 색종이가 놓일 구간에 해당 색종이 번호를 저장
			for(int r=a; r<a+width; r++) {
				for(int c=b; c<b+height; c++) {
					map[r][c] = i+1;
				}
			}
		}
		
		// 배열을 순회하며 각 번호가 있는 수를 셈 (가려지지 않은 면적 세기)
		int cnt = 0;
		for(int n = 0; n<N; n++) {
			for(int i=0; i<1001; i++) {
				for(int j=0; j<1001; j++) {
					if(map[i][j]==n+1) cnt++;
				}
			}
			sb.append(cnt).append("\n");
			cnt = 0;
		}
		System.out.println(sb);
	}

}
