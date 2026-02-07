import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int cnt = 0;
		for(int i=a; i<=b; i++) {
			if(findNum(i)) cnt++;
		}
		System.out.println(cnt);
	}
	
	public static boolean findNum(int num) {
		if(num%3==0 || find369(num)) {
			return true;
		}
		else return false;
	}

	private static boolean find369(int num) {
		while(num>0) {
			if(num%10==3 ||num%10==6 ||num%10==9) {
				return true;
			}
			num = num/10;
		}
		
		return false;
	}
}