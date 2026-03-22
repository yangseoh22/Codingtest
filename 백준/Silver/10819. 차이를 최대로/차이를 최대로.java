import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] arr,nums;
	static boolean[] V;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		V = new boolean[N];
		perm(0);
		
		System.out.println(max);
	}
	
	// 인덱스 순열 생성
	private static void perm(int idx) {
		if(idx == N) {
			cal(arr);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!V[i]) {
				arr[idx] = i;
				V[i] = true;
				perm(idx+1);
				V[i] = false;
			}
		}
	}
	
	// 배열 계산
	private static void cal(int[] list) {
		int sum = 0;
		for(int i=0; i<list.length-1; i++) {
			int tmp = Math.abs(nums[list[i]] - nums[list[i+1]]);
			sum += tmp;
		}
		
		max = Math.max(max, sum);
	}
}
