import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<>(); 
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			String cmd = st.nextToken();
			int item = -1;
			if(cmd.equals("push")) item = Integer.parseInt(st.nextToken());
			
			switch(cmd) {
			case "push": q.add(item); break;
			case "front" : sb.append(q.peek()).append("\n"); break;
			case "size" : sb.append(q.size()).append("\n"); break;
			case "empty" : sb.append(q.isEmpty()?1:0).append("\n"); break;
			case "pop" : sb.append(q.poll()).append("\n"); break;
			}
		}
		System.out.println(sb);
	}

}
