import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		int day = y;  // 일 수를 미리 더해줌
		
		// 지난 개월 수에 따른 일 수 계산을 추가로 합
		for (int i=1; i<x; i++) {
				switch(i) {
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:
					day+=31;
					break;
				case 2: day+=28; break;
				default: day+=30; break;
			}
		}
		
		String[] date = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		System.out.println(date[day%7]);
    }
}