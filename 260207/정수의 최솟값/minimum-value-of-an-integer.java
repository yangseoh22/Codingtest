import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(min(a, b, c));
	}
	
	public static int min(int x, int y, int z) {
		if(x>y) {
			if(y<z) return y;
			else return z;
		}
		else {
			if(x<z) return x;
			else return z;
		}
	}
}