import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		long diff = Math.abs(A-B)-1;
		if(diff==-1 || diff==1) diff = 0;
		sb.append(diff).append("\n");
		
		long start = Math.min(A, B);
		long end = Math.max(A, B);
		for(long i=start+1; i<end; i++) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}

}
