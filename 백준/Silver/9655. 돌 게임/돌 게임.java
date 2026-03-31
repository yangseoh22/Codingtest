import java.util.*;
import java.io.*;

public class Main {
	static int turn;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		turn = 0;
		dfs(N-1, N-3, turn);
		
		if(turn%2==0) sb.append("SK");
		else sb.append("CY");
		
		System.out.println(sb);
	}

	private static void dfs(int i, int j, int t) {
		if(i == 0 || j == 0) {
			turn = t;
			return;
		}
		
		dfs(i-1, j-3, t+1);
	}

}
