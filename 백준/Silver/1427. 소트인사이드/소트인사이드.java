import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		char[] tmp = sc.nextLine().toCharArray();
		int[] num = new int[tmp.length];
		
		// 문자로 받은 배열을 정수 배열로 변경
		for(int i=0; i<tmp.length; i++) {
			num[i] = tmp[i]-'0';
		}
		
		// 오름차순 정렬
		Arrays.sort(num);
		
		// 내림차순 출력
		for(int i=num.length-1; i>=0; i--) {
			sb.append(num[i]);
		}
		System.out.println(sb);
	}

}
