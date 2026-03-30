import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<String> str;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		str = new ArrayList<>();
		for(int i=0; i<N; i++) {
			String tmp = br.readLine();
			if(findPrev(tmp)) continue;  // 중복이면 무시
			str.add(tmp);  // 중복 아니면 추가
		}
		
		Collections.sort(str, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				// 길이가 같을 때는 알파벳 순
				if(s1.length() == s2.length()) {
					return s1.compareTo(s2);
				}
				
				// 길이가 다르다면  길이 순
				return s1.length() - s2.length();
			}
		});
		
		for(String s : str) {
			sb.append(s).append("\n");
		}
		
		System.out.println(sb);
	}

	// 중복 검사
	private static boolean findPrev(String s) {
		for(int i=0; i<str.size(); i++) {
			if(str.get(i).equals(s)) return true;
		}
		
		return false;
	}

}
