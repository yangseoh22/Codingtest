import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int season = 665;  // 현재 시즌
		int check = 0;  // 몇 번째까지 확인했는지
		
		do {
			season++;
			if(Checking(season)) check++;
		}while(check<n);
		
		System.out.println(season);
	}

	private static boolean Checking(int season) {
		char[] tmp = String.valueOf(season).toCharArray();
		int c = 0;  // 6이 연속으로 나온 개수
		for(int i=0; i<tmp.length; i++) {
			// 6이 나옴
			if(tmp[i]=='6') { 
				c++;
				if (c==3) return true;
			}
			// 6이 아님
			else {
				c=0;
			}
		}
		
		return false;
	}
	
	

}
