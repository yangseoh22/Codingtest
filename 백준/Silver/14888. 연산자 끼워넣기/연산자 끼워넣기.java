import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] arr, p;
	static boolean[] V;
	static ArrayList<Integer> op;
	static int maxResult = Integer.MIN_VALUE;
	static int minResult = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 0:+, 1:-, 2:*, 3:/ 으로 리스트 생성 -> 길이는 N-1
		op = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			for(int j=0; j<tmp; j++) {
				op.add(i);
			}
		}
		
		p = new int[N-1];
		V = new boolean[N-1];
		permu(0);
		
		sb.append(maxResult).append("\n");
		sb.append(minResult);
		
		System.out.println(sb);
	}
	
	// 연산자 순열
	private static void permu(int idx) {
		if(idx == N-1) {
			cal();
			return;
		}
		
		for(int i=0; i<N-1; i++) {
			if(!V[i]) {
				V[i] = true;
				p[idx] = op.get(i);
				permu(idx + 1);
				V[i] = false;
			}
		}
	}

	private static void cal() {
		int result = arr[0];
		for(int i=0; i<N-1; i++) {
			if(p[i] == 0) {
				result += arr[i+1];
			}
			else if(p[i] == 1) {
				result -= arr[i+1];
			}
			else if(p[i] == 2) {
				result *= arr[i+1];
			}
			else if(p[i] == 3) {
				result /= arr[i+1];
			}
		}
		
		maxResult = Math.max(maxResult, result);
		minResult = Math.min(minResult, result);
	}
	
}
