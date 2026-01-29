import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=T; test_case++) {
			
			sb.append("#"+test_case+" ");
			
			// 카드 수
			int n = Integer.parseInt(br.readLine());
			
			String[] card = new String[n];
			st = new StringTokenizer(br.readLine());
			
			// 카드 내용 넣기
			for(int i=0; i<n; i++) {
				card[i] = st.nextToken();
			}
			
			int one = 0;  // 앞 부분 인덱스
			int two = (n+1)/2;  // 뒷 부분 인덱스 - 홀수일 경우 앞 덱에 하나 더 넣기 위함
			for(int i=0; i<n; i++) {
				
				if(i%2==0) {
					sb.append(card[one++] + " ");
				}
				else {
					sb.append(card[two++] + " ");
				}
				
			}
			
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
