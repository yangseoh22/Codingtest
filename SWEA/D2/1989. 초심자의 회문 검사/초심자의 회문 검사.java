import java.util.*;
import java.io.*;


public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			char[] word = br.readLine().toCharArray();
			
			int idx = word.length-1;
			boolean flag = true;
			for(int i=0; i<word.length/2; i++) {
				if(word[i] != word[idx--]) {
					flag = false;
					break;
				}
			}
			
			if(flag) sb.append(1).append("\n");
			else sb.append(0).append("\n");
		}
		System.out.println(sb);
	}

}
