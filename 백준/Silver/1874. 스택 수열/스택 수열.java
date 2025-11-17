import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();

		int now = 0;  // 현재까지 넣은 수
		
		// 1~n을 스택 연산 했을 때, 주어진 수열이 나올까?
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());  // 수열 입력
			
			if(num>now) {  // 현재 수 보다 num이 크다면 현재 수~num까지 push
				for(int j=now+1; j<=num; j++) {  // num까지 push
					stack.push(j);
					sb.append("+\n");
					now++;
				}
				// 맨 위값 pop
				if(stack.pop()==num) {  // pop이 잘 됐으면 -
					sb.append("-\n");
				}
				else {
					sb.setLength(0);  // pop이 안됐으면 'no'
					sb.append("NO");
					break;
				}
				
			}
			// 이미 num보다 큰 수까지 push 된 상태이므로 pop
			else if(num<=now) {
				if(stack.pop()==num) {
					sb.append("-\n");
				}
				else {
					sb.setLength(0);
					sb.append("NO");
					break;
				}
			}
		}
		System.out.println(sb.toString());
	}
}