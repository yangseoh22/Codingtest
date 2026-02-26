import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] A;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[M];
		
		combi(1, 0);
		
		System.out.println(sb);
	}
	private static void combi(int start, int len) {
		if(len==M) {
			printArray();
			return;
		}
		
		for(int i=start; i<=N; i++) {
			A[len] = i;
			combi(i + 1, len + 1);
		}
	}
	
	private static void printArray() {
		for(int num : A) {
			sb.append(num).append(" ");
		}
		sb.append("\n");
	}
}
