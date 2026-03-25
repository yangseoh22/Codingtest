import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int cnt = Integer.parseInt(br.readLine());
		
		
		for(int i=0; i<cnt; i++) {
			int odd = 0;
			int even = 0;

			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			for(int j=0; j<n; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp % 2 == 0) even += tmp;
				else odd += tmp;
			}
			
			if(even>odd) sb.append("EVEN").append("\n");
			else if(even<odd) sb.append("ODD").append("\n");
			else sb.append("TIE").append("\n");
		}
		
		System.out.println(sb);
	}

}
