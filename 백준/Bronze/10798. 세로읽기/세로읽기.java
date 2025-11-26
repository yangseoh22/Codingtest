import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		char[][] word = new char[5][15];
		
		// 각 행에 문장 입력
		for(int i=0; i<5; i++) {
			char[] tmp = sc.nextLine().toCharArray();
			
			for(int j=0; j<tmp.length; j++) {
				word[i][j] = tmp[j];
			}
		}
		
		// 세로 방향 읽기
		for(int i=0; i<15; i++) {
			for(int j=0; j<5; j++) {
				// 공백은 무시
				if(word[j][i]=='\0') continue;
				
				sb.append(word[j][i]);
			}
		}
		
		System.out.println(sb);
	}

}
