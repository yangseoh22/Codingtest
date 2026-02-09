import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 학생 수
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int idx = Integer.parseInt(st.nextToken());  // 뽑은 번호
			// (현재 줄 선 사람 수 - 뽑은 번호 수) 위치에 추가
			list.add(list.size() - idx, i+1);
		}
		
		// 출력
		for(int s : list) {
			sb.append(s).append(" ");
		}
		System.out.println(sb);
	}

}
