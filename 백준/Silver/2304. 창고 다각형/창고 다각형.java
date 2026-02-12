import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Map<Integer, Integer> building = new HashMap<>();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[1001];
		int max = Integer.MIN_VALUE;
		int idx = 0;
		
		
		for(int i=0; i<N; i++) {
			// 위치 L, 높이 H
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			arr[L] = H;
			if(max<H) {
				max = H;
				idx = L;
			}
		}
		
		int start = 0;
		int result = 0;
		int leftIdx = 0;
		max = Integer.MIN_VALUE;
		
		// 처음부터 가장 높은 곳(idx)의 가장 높은 곳 찾기
		for(int i=start; i<=idx; i++) {
			if(max<arr[i]) {
				max = arr[i];
				leftIdx = i;
			}
			result += max;
		}
		
		max = Integer.MIN_VALUE;
		int rightIdx = 0;
		// 뒤부터 가장 높은 곳(idx)의 가장 높은 곳 찾기
		for(int i=1000; i>idx; i--) {
			if(max<arr[i]) {
				max = arr[i];
				rightIdx = i;
			}
			result += max;
		}
		
		System.out.println(result);
	}

}
