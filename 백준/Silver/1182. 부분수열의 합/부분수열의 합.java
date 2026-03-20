import java.util.*;
import java.io.*;

public class Main {
	static int N, S, result;
	static int[] nums;
	static boolean[] selected;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		
		st =new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		result = 0;
		selected = new boolean[N];
		subset(0);
		
		System.out.println(result);
	}
	
	private static void subset(int cnt) {
		if(cnt == N) {
			// 만들어진 부분 집합을 리스트로 생성
			ArrayList<Integer> tmp = new ArrayList<>();
			for(int i=0; i<N; i++) {
				if(selected[i]) {
					tmp.add(nums[i]);
				}
			}
			
			// 공집합이 아닐 때만 계산
			int sum = 0;
			if(tmp.size()!=0){
				for(int t : tmp) {
					sum += t;
				}
				if(sum == S) result++;
			}
			return;
		}
		
		selected[cnt] = true;
		subset(cnt + 1);
		
		selected[cnt] = false;
		subset(cnt + 1);
	}
	
}
