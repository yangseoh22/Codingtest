/*
 * 
 */

import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Long N = Long.parseLong(br.readLine());
		
		if(N%2==0) sb.append("CY");
		else sb.append("SK");
		
		System.out.println(sb);
	}

}
