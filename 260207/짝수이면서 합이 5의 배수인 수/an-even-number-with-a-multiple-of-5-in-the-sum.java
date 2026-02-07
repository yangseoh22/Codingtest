import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		if(findNum(n)) System.out.println("Yes");
		else System.out.println("No");
	}
	
	public static boolean findNum(int num) {
		if(num%2==0) {
			if((num/10 + num%10)%5==0) return true;
			else return false;
		}
		else return false;
	}
}