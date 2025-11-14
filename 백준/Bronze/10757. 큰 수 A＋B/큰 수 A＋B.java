import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 매우 큰 정수 생성
		BigInteger a = sc.nextBigInteger();
		BigInteger b = sc.nextBigInteger();
		
		// 매우 큰 정수 합계 메소드
		System.out.println(a.add(b));
	}
}
