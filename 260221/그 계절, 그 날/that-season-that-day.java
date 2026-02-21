import java.util.Scanner;

public class Main {
	static String season = "";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int y = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();
        
        boolean flag = testDate(y, m, d)? true : false;
       
        if(flag) {
        	checkSeason(m);
        	System.out.println(season);
        }
        else System.out.println(-1);
	}

	private static boolean testDate(int y, int m, int d) {
		// 각 월의 끝나는 날
		int[] day = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		// 윤년이라면, 2월은 29일까지
		boolean yoon = false;
		if(y%4==0) {
			yoon = true;
			if(y%100==0) {
				yoon = false;
				if(y%400==0) yoon = true;
			}
		}
		if(yoon) day[2] = 29;
		
		// 존재하는 날인가
		if(m>=1 && m<=12) {
			if(d>=0 && d<=day[m]) return true;
		}
		
		return false;
	}
	
	private static void checkSeason(int m) {
		
		switch(m) {
    	case 3:
    	case 4:
    	case 5:
    		season = "Spring";
    		break;
    	case 6:
    	case 7:
    	case 8:
    		season = "Summer";
    		break;
    	case 9:
    	case 10:
    	case 11:
    		season = "Fall";
    		break;
    	case 12:
    	case 1:
    	case 2:
    		season = "Winter";
    		break;
    	}
	}
}
