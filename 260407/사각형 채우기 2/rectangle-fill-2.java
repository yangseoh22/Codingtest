import java.io.*;
import java.util.Arrays;

public class Main {
	static int[] memo;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		memo = new int[N+1];
		Arrays.fill(memo, -1);
		memo[0] = 1;
		memo[1] = 1;
		
		for(int i=2; i<=N; i++) {
			if(memo[i] != -1) continue;
			
			memo[i] = (memo[i-1]+memo[i-2]*2) % 10007;
		}
		
		System.out.println(memo[N]);
	}

}
