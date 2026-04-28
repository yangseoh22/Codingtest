import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for(int t=1; t<=TC; t++) {
			String tmp = br.readLine();
			char[] word = tmp.toCharArray();
			int left = 0;
			int right = word.length - 1;
			boolean flag = true;
			while(left<right) {
				if(word[left++] != word[right--]) {
					flag = false;
					break;
				}
			}
			
			sb.append("#").append(t).append(" ").append(flag?1:0).append("\n");
		}
		System.out.println(sb);
	}

}
