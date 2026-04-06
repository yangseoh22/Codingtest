import java.io.*;
import java.util.Arrays;

public class Main {
	static int[] memo;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		memo = new int[N+1];
		Arrays.fill(memo, -1);
		
		int result = fibo(N);
		
		System.out.println(result);
	}

	private static int fibo(int n) {
		if(memo[n]!=-1) return memo[n];
		
		if(n==0) return 0;
		else if(n==1 || n==2) return 1;
		else {
			memo[n] = fibo(n-1) + fibo(n-2);
		}
	
		return memo[n];	
	}

}
