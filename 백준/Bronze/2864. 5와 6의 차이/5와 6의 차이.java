import java.util.*;
import java.io.*;

public class Main {
	static String A, B;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		A = st.nextToken();
		B = st.nextToken();
		
		int min = calMin();
		int max = calMax();
		
		sb.append(min).append(" ").append(max);
		System.out.println(sb);
	}

	private static int calMin() {
		A = A.replace("6", "5");
		B = B.replace("6", "5");
		int a = Integer.parseInt(A);
		int b = Integer.parseInt(B);
		return a+b;
	}

	private static int calMax() {
		A = A.replace("5", "6");
		B = B.replace("5", "6");
		int a = Integer.parseInt(A);
		int b = Integer.parseInt(B);
		return a+b;
	}

}
