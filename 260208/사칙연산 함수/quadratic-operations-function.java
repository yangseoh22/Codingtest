import java.util.Scanner;

public class Main {
	static int result = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		String o = sc.next();
		int c = sc.nextInt();
		
		if(cal(a, o, c)) {
			System.out.println(a + " " + o + " " + c + " = " + result);
		}
		else System.out.println("False");
	}
	
	public static boolean cal(int x, String o, int y) {
		switch(o) {
		case "+" :
			result = x+y;
			return true;
		case "-" :
			result = x-y;
			return true;
		case "*" :
			result = x*y;
			return true;
		case "/" :
			result = x/y;
			return true;
		default:
			return false;
		}
	}

}
