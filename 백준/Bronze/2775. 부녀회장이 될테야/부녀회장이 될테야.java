import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int k = Integer.parseInt(br.readLine());  // 층
			int n = Integer.parseInt(br.readLine());  // 호
			
			int[][] apart = new int[k+1][n];
			
			for(int i=0; i<n; i++) {
				apart[0][i] = i+1;
			}
			
			for(int i=1; i<=k; i++) {  // 1층부터 층마다 반복
				for(int j=0; j<n; j++) {  // 호
					if(j==0) apart[i][j] = 1;
					else apart[i][j] = apart[i][j-1] + apart[i-1][j];
				}
			}
			
			sb.append(apart[k][n-1]).append("\n");
		}
		System.out.println(sb);
	}

}
