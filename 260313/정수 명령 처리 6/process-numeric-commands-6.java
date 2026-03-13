import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			String cmd = st.nextToken();
			switch (cmd) {
			case "push":
				// 최대 우선순위 큐이므로 -붙이기
				pq.add(-Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				sb.append(-pq.peek()).append("\n");  // 꺼내고 -붙이고, 출력
				pq.remove();  // 삭제
				break;
			case "size":
				sb.append(pq.size()).append("\n");
				break;
			case "empty":
				sb.append(pq.isEmpty()? 1 : 0).append("\n");
				break;
			case "top":
				sb.append(-pq.peek()).append("\n");  // 꺼낼 때 -붙이기
				break;
			}
		}
		
		System.out.println(sb);
	}

}
