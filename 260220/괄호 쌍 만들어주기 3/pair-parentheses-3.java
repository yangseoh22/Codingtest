import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		char[] tmp = new char[str.length()];
		List<Integer> idx = new ArrayList<>();
		for(int i=0; i<str.length(); i++) {
			tmp[i] = str.charAt(i);
			if(tmp[i]=='(') idx.add(i);  // 여는 괄호 위치 저장
		}
		
		int cnt = 0;
		for(int i=0; i<idx.size(); i++) {
			int now = idx.get(i);  // 여는 괄호 찾아서
			
			// 그 다음으로 나오는 닫는 괄호의 개수 카운트
			for(int j=now+1; j<str.length(); j++) {
				if(tmp[j]==')') cnt++;
			}
		}
		System.out.println(cnt);
	}

}
