import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int K = Integer.parseInt(br.readLine());
		
		int[] len = new int[6];
		int idxW = 0;
		int idxH = 0;
		int maxW = Integer.MIN_VALUE;
		int maxH = Integer.MIN_VALUE;
		for(int i=0; i<6; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			len[i] = Integer.parseInt(st.nextToken());
			
			// 가로
			if(dir==3 || dir==4) {
				if(maxW<len[i]) {
					maxW = len[i];
					idxW = i;
					
				}
			}
			// 세로
			if(dir==1 || dir==2) {
				if(maxH<len[i]) {
					maxH = len[i];
					idxH = i;
				}
			}
		}

		// 최대 가로/세로의 3번째 다음거가 작은 사각형의 가로/세로
		int smallW = len[(idxH+3+6)%6];
		int smallH = len[(idxW+3+6)%6];
		
		int result = ((maxW*maxH)-(smallW*smallH)) * K;
		sb.append(result);
		System.out.println(sb);
		
	}

}
