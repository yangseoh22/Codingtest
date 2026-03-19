import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int maxT = Integer.MIN_VALUE;
		int[] tree = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			maxT = Math.max(tree[i], maxT); 
		}
		
		int low = 0;
		int high = maxT;
		int result = maxT;
		while(low<=high) {
			long sumTree = 0;
			int H = (low + high)/2;  // 이분탐색
			for(int t : tree) {
				if(t >= H) {
					sumTree += t - H;					
				}
			}
			
			if(sumTree < M) {
				high = H - 1;
			}
			else if(sumTree >=M) {
				low = H + 1;
				result = H;
			}
			
		}

		System.out.println(result);
	}

}
