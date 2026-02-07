import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
		
		System.out.println(isYoon(y));
	}
	
	public static boolean isYoon(int year) {
		if(year%4==0) {
			if(year%100==0 && year%400!=0) return false;
			return true;
		}
		
		return false;
	}
}