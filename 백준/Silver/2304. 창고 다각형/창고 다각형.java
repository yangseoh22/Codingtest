import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[1001];
		int maxH = Integer.MIN_VALUE;
		int maxIdx = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			arr[L] = H;
			if(maxH<arr[L]) {
				maxIdx = L;
				maxH = H;
			}	
		}
		
		int result = 0;
		int max = 0;
		// 처음 부터 최장 기둥까지
		for(int i=0; i<=maxIdx; i++) {
			if(max<arr[i]) {
				max = arr[i];
			}
			result += max;
		}
		
		max = 0;
		// 최장 기둥부터 맨끝까지
		for(int i=1000; i>maxIdx; i--) {
			if(max<arr[i]) {
				max = arr[i];
			}
			result += max;
		}
		sb.append(result);
		System.out.println(sb);
	}

}
