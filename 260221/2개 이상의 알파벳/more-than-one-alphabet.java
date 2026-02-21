import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.next();

		System.out.println(solve(A)? "Yes":"No");

	}

	private static boolean solve(String A) {
		int[] alpha = new int[26];
		for (int i = 0; i < A.length(); i++) {
			alpha[A.charAt(i) - 'a']++;
		}
		
		int cnt = 0;
		for (int i = 0; i < 26; i++) {
			if(alpha[i]>0) cnt++;
		}
		
		if(cnt>=2) return true;
		else return false;
	}
}