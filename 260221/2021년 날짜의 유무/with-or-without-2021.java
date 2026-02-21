import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int d = sc.nextInt();
        
        System.out.println(testDate(m, d)? "Yes" : "NO");
	}

	private static boolean testDate(int m, int d) {
		// 각 월의 끝나는 날
		int[] day = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		if(d>=0 && d<=day[m]) return true;
		
		return false;
	}
}