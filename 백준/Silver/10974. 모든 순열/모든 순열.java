import java.util.*;
import java.io.*;


public class Main {
	static int N;
	static int[] arr;
	static boolean[] V;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		V = new boolean[N+1];
		
		// 1~N의 수로 이루어진 N길이의 순열 출력
		perm(0);
		
		System.out.println(sb);
	}

	private static void perm(int idx) {
		if(idx == N) {
			for(int a : arr) {
				sb.append(a).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(!V[i]) {
				arr[idx] = i;
				V[i] = true;
				perm(idx + 1);
				V[i] = false;
			}
		}
	}

}
