import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(cal(a,b));
	}
	
	public static int cal(int x, int y) {
		int result = 1;
		for(int i=0; i<y; i++) {
			result *= x;
		}
		
		return result;
	}
}