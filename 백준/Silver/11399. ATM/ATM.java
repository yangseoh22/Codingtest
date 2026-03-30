import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int min = Integer.MAX_VALUE;
	static int[] times;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		times = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			times[i] = Integer.parseInt(st.nextToken());
		}
		
		// 작은 시간의 사람이 앞에 서야 모두가 유리
		Arrays.sort(times); 
		
		int[] tmp = new int[N];
		tmp[0] = times[0];
		for(int i=1; i<N; i++) {
			tmp[i] = tmp[i-1] + times[i];
		}
		
		int sum = 0;
		for(int t : tmp) {
			sum += t;
		}
		min = Math.min(sum, min);
		
		sb.append(min);
		System.out.println(sb);
	}
}
