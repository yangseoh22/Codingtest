import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 소문자 a의 아스키코드는 97, 알파벳 개수 26개를 이용
		int tmp[] = new int[26];
		
		char[] s = sc.next().toCharArray();
		
		for(int i=0; i<s.length; i++) {
			tmp[s[i]-97]++;
		}
		
		for(int i=0; i<26; i++) {
			System.out.print(tmp[i]+" ");
		}
	}
}