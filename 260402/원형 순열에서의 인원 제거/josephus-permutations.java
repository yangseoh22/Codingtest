import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<>(); 
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=N; i++) {
			q.add(i);
		}
		
		while(!q.isEmpty()) {
			for(int i=0; i<K-1; i++) {
				q.add(q.peek());  // 앞에 있던 요소를 뒤에 넣고
				q.poll();  // 앞에 있던 요소를 삭제
			}
			sb.append(q.poll()).append(" ");  // K번째 사람 삭제
		}
		
		System.out.println(sb);
	}

}
