import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			pq.add(-Integer.parseInt(st.nextToken()));
		}
		
		for(int i=0; i<M; i++) {
			int max = -pq.poll();  // 최댓값 빼내고
			
			pq.add(-(max-1));  // 1빼고 -붙여서 다시 넣기
		}
		
		System.out.println(-pq.peek());
	}

}
