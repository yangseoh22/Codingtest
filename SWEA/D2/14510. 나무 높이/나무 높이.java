import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			int N = Integer.parseInt(br.readLine());
			
			tree = new int[N];
			int max = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				tree[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, tree[i]);
			}
			
			int one = 0;  // 필요한 1일의 수
			int two = 0;  // 필요한 2일의 수
			for(int i=0; i<N; i++) {
				int tmp = max - tree[i];  // 최대 길이와의 차이
				
				one += tmp%2;
				two += tmp/2;
			}
			
			// 1일과 2일을 비슷하게 만들기
			while(one+1<two) {
				two--;
				one += 2;
			}
			
			// 일 수 계산
			int day = 0;
			
			if(one>two) day = one*2-1;
			else day = two*2;
			
			sb.append("#").append(t).append(" ").append(day).append("\n");
		}
		System.out.println(sb);
	}

}
