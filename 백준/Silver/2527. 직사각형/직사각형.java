import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<4; i++) {
			st = new StringTokenizer(br.readLine());
			int ax = Integer.parseInt(st.nextToken());
			int ay = Integer.parseInt(st.nextToken());
			int ap = Integer.parseInt(st.nextToken());
			int aq = Integer.parseInt(st.nextToken());
			int bx = Integer.parseInt(st.nextToken());
			int by = Integer.parseInt(st.nextToken());
			int bp = Integer.parseInt(st.nextToken());
			int bq = Integer.parseInt(st.nextToken());
			
			if(ap<bx || aq<by || ay>bq || bp<ax) sb.append("d").append("\n");
			else if ((ap == bx && by == aq) || (by == aq && bp == ax) || (ay == bq && ap == bx)|| (bp == ax && bq == ay)) sb.append("c").append("\n");
			else if (aq==by || ap==bx || ax==bp ||ay == bq) sb.append("b").append("\n");
			else sb.append("a").append("\n");
		}
		System.out.println(sb);
	}


}
