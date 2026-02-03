import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int TC = 10;

		for (int t = 1; t <= TC; t++) {
			sb.append("#").append(t).append(" ");
			
			int N = Integer.parseInt(br.readLine());  // 정점의 수
			boolean isValid = true;
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int cnt = st.countTokens();  // 토큰 개수
				
				if(!isValid) continue;
				
				st.nextToken();
				String token = st.nextToken();
				
				// 토큰이 4개 = 자식 노드가 있음
				// 자식 노드가 있는 노드는 연산자여야 함 -> 숫자면 false
				if(cnt == 4) {
					if(token.charAt(0) >= '0' && token.charAt(0) <= '9') {
						isValid = false;
					}
					
				}
				// 리프 노드인 경우 숫자여야 함 -> 연산자면 false
				else {
					if(token.equals("+") || token.equals("-") ||token.equals("*") || token.equals("/")){
						isValid = false;
					}
				}
				
			}
			
			if(isValid) sb.append(1).append("\n");
			else sb.append(0).append("\n");
		}
		System.out.println(sb);
	}

}
