import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double sumCredit = 0;  // 학점의 총합
		double total = 0;  // (학점 * 과목평점 )의 합
		
		for(int i=0; i<20; i++) {
			String tmp = sc.nextLine();
			String[] list = tmp.split(" ");
			
			if (list[2].equals("P")) continue;  // 등급이 P인 과목은 제외
			
			double grade = countGrade(list[2]);  // 해당 과목에서 얻은 평점

			// 학점 * 과목평점의 합과 학점의 총합 구하기
			double credit = Double.parseDouble(list[1]);
			
			sumCredit += credit;
			total += credit * grade;
			
		}
		
		System.out.println(total/sumCredit);
	}

	// 등급에 따른 과목 평점 구하기
	private static double countGrade(String grade) {
		double grad = 0;
		
		switch(grade) {
		case "A+": grad = 4.5; break;
		case "A0": grad = 4.0; break;
		case "B+": grad = 3.5; break;
		case "B0": grad = 3.0; break;
		case "C+": grad = 2.5; break;
		case "C0": grad = 2.0; break;
		case "D+": grad = 1.5; break;
		case "D0": grad = 1.0; break;
		case "F": grad = 0.0; break;
		default: grad = 0.0; break;
		}
		
		return grad;
	}
}
