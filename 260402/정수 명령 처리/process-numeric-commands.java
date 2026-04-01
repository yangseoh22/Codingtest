import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> stack = new ArrayList<>();
		
		int N = Integer.parseInt(br.readLine());
		
		int item = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if(cmd.equals("push")) {
				item = Integer.parseInt(st.nextToken());
			}
			
			if(cmd.equals("push")) {
				stack.add(item);
			}
			else if(cmd.equals("pop")) {
				sb.append(stack.get(stack.size()-1)).append("\n");
				stack.remove(stack.size()-1);
			}
			else if(cmd.equals("size")) {
				sb.append(stack.size()).append("\n");
			}
			else if(cmd.equals("empty")) {
				int tmp = stack.isEmpty()? 1 : 0;
				sb.append(tmp).append("\n");
			}
			else {
				sb.append(stack.get(stack.size()-1)).append("\n");
			}
		}
		System.out.println(sb);
	}

}
