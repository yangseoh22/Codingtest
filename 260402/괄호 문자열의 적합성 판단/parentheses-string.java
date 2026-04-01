import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		
		char[] str = br.readLine().toCharArray();
		boolean flag = true;
		for(int i=0; i<str.length; i++) {
			flag = true;
			if(str[i]=='(')
				stack.push(str[i]);
			else {
				if(stack.isEmpty()) {
					flag = false;
					break;
				}
				else {
					stack.pop();
				}
			}
		}
		if(!stack.isEmpty()) flag = false;
		
		if(!flag) sb.append("No");
		else sb.append("Yes");
		System.out.println(sb);
	}

}
