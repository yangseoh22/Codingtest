import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int turn = 0;
		turn = dfs(N-1, N-3, turn);
		
		if(turn%2==0) sb.append("SK");
		else sb.append("CY");
		
		System.out.println(sb);
	}

	private static int dfs(int i, int j, int turn) {
		if(i == 0 || j == 0) {
			return turn;
		}
		
		return dfs(i-1, j-3, turn+1);
	}

}
