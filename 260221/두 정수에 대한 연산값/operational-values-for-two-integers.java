import java.util.Scanner;

public class Main {
    static class IntWrapper {
		int x;
		
		public IntWrapper(int x) {
			this.x = x;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
        int b = sc.nextInt();
        
        IntWrapper aa = new IntWrapper(a);
        IntWrapper bb = new IntWrapper(b);
        
        solve(aa, bb);
        
        System.out.println(aa.x + " " + bb.x);
        
    }

	private static void solve(IntWrapper aa, IntWrapper bb) {
		if(aa.x>bb.x) {
			aa.x += 25;
			bb.x *= 2;
		}
		else {
			bb.x += 25;
			aa.x *= 2;
		}
	}
}