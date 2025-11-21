import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String a = br.readLine();
		String[] str = a.split("-");  // 뺄셈 기호 기준으로 나누기
		
		int result = 0;
		for(int i=0; i<str.length; i++) {
			int tmp = mySum(str[i]);  // 나눈 각 덩어리들의 합 구하기
			
			if (i==0) result += tmp;
			else result -= tmp;
		}
		
		System.out.println(result);
	}

	private static int mySum(String s) {
		String[] addStr = s.split("[+]");  // 덧셈 기호 기준으로 나누기
		
		int sum = 0;
		for(int i=0; i<addStr.length; i++) {
			sum += Integer.parseInt(addStr[i]);  // 나눈 각 덩어리들의 합 구하기
		}
		
		return sum;
	}

}
