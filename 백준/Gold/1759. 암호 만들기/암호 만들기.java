import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb;
	static int L, C;
	static char[] alpha, code, mo;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		mo = new char[]{'a', 'e', 'i', 'o', 'u'};
		alpha = new char[C];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<C; i++) {
			String tmp = st.nextToken();
			alpha[i] = tmp.charAt(0);
		}
		
		Arrays.sort(alpha);  // 오름차순 정렬
		
		code = new char[L];
		combi(0, 0);
		
		System.out.println(sb);
	}
	
	public static void combi(int depth, int start) {
		
		if(depth == L) {
			// 최소 모음/자음 개수 불만족 시 무시
			int cm = cntMo(code);
			if(cm<1 || (L-cm)<2) return;
			
			for(char c : code) {
				sb.append(c);
			}
			sb.append("\n");
			
			// 배열 출력
			return;
		}
		
		// 조합 구하기
		for(int i=start; i<C; i++) {
			code[depth] = alpha[i];
			
			combi(depth + 1, i + 1);
		}
	}

	private static int cntMo(char[] testCode) {
		int moCnt = 0;  // 포함된 모음 개수
		
		for(char c : testCode) {
			for(char ch : mo) {
				if(ch==c) moCnt++;
			}
		}
		
		return moCnt;
	}
}
