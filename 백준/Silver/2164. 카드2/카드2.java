import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Queue<Integer> queue = new LinkedList<>();
		
		int n = Integer.parseInt(br.readLine());
		
		// 1~n을 순서대로 넣은 큐 생성
		for(int i=1; i<=n; i++) {
			queue.add(i);
		}
		
		int turn = 1;
		while(queue.size()>1) {
			// 홀수 차례에는 맨 위 카드 버리기
			if(turn%2!=0) {
				queue.poll();
				turn++;
			}
			// 짝수 차례에는 맨 위 카드 버렸다가 다시 삽입
			else {
				int tmp = queue.poll();
				queue.add(tmp);
				turn++;
			}
		}
		
		System.out.println(queue.peek());
	}
}
