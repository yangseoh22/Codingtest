import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			for(int j=0; j<=N-3; j++) {
				int cnt = 0;
				for(int k=j; k<j+3; k++) {
					cnt += map[i][k];
				}
				max = Math.max(max, cnt);
			}
		}
		
		System.out.println(max);
	}

}
