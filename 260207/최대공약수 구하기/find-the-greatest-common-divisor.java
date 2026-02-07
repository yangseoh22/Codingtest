import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int m = sc.nextInt();
	    
	    System.out.println(play(n, m));
	}

	private static int play(int n, int m) {
		int s = n>m ? m : n;
		for(int i=s; i>0; i--) {
			if(n%i==0 && m%i==0) return i;
		}
		
		return 0;
	}
}