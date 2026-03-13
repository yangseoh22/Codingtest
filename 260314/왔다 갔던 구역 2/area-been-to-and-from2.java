import java.util.*;
import java.io.*;

public class Main {
	static int OFFSET = 10000;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());

		int[] tmp = new int[2*OFFSET];
		int pos = 0 + OFFSET;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			char dir = st.nextToken().charAt(0);
			
			if(dir == 'R') {
				for(int k=pos; k<pos+cnt; k++) {
					tmp[k]++;
				}
				pos += cnt;
			}
			else if(dir == 'L') {
				for(int k=pos-cnt; k<pos; k++) {
					tmp[k]++;
				}
				pos -= cnt;
			}
		}
		
		int result = 0;
		for(int i=0; i<tmp.length; i++) {
			if(tmp[i]>=2) result++;
		}
		
		System.out.println(result);
	}

}
