import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] tree = new int[N];
		int maxH = Integer.MIN_VALUE;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			maxH = Math.max(maxH, tree[i]);
		}
		
		int down = 0;
		int up = maxH;
		int res = -1;
		
		while(down<=up) {
			int H = (down+up)/2;
			long sum = 0;
			for(int t : tree) {
				if(t>H) {
					sum += t-H;
				}
			}

			if(sum>=M) {
				res = H;
				down = H + 1;
			}
			else if(sum<M) {
				up = H - 1;
			}
		}
		
		System.out.println(res);
	}

}
