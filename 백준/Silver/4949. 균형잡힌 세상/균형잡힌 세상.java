import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		while (true) {
			Stack<Character> stack = new Stack<>();
			String lines = br.readLine();
			if(lines.equals("."))break;
			
			char[] str = lines.toCharArray();
			boolean isPair = true;
			for(int i=0; i<str.length; i++) {
				// 여는 괄호는 스택에 넣기
				if(str[i] == '(' || str[i] == '[') stack.push(str[i]);
				// 닫는 괄호라면
				else if(str[i] == ')' || str[i] == ']') {
					// 스택이 비어있지 않다면
					if(!stack.isEmpty()) {
						if(str[i]==')' && stack.peek()=='(') {
							stack.pop();
						}
						else if (str[i]==']' && stack.peek()=='[') {
							stack.pop();
						}
						else {
							isPair=false;
							break;
						}
					}
					else{
						isPair=false;
						break;
					}
				}
			}
			// 짝이 안맞는 게 없었고, 스택이 비어있다면 균형이 맞음
			if(isPair && stack.isEmpty()) sb.append("yes").append("\n");
			else sb.append("no").append("\n");
		}

		System.out.println(sb);
	}

}
