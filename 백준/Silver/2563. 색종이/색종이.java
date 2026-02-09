import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new boolean[100][100];
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			setMap(x, y);
		}
		
		int area = 0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(map[i][j]) area++;
			}
		}
		
		System.out.println(area);
	}
	private static void setMap(int x, int y) {
		for(int i=x; i<x+10; i++) {
			for(int j=y; j<y+10; j++) {
				map[i][j] = true;
			}
		}
	}

}
