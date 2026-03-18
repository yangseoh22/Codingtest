import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		BigInteger num, two, zero;
		
		int N = Integer.parseInt(br.readLine());
		
		zero = new BigInteger("0");
		two = new BigInteger("2");
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			num = new BigInteger(st.nextToken());
			if(num.remainder(two).compareTo(zero) == 1) sb.append("odd").append("\n");
			else sb.append("even").append("\n");
		}
		
		System.out.println(sb);
	}

}
