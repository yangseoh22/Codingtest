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
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        IntWrapper newN = new IntWrapper(n);
        IntWrapper newM = new IntWrapper(m);
        
        swap(newN, newM);

        System.out.println(newN.x + " " + newM.x);
    }

	private static void swap(IntWrapper n, IntWrapper m) {
		int tmp = m.x;
		m.x = n.x;
		n.x = tmp;
	}

}