import java.io.*;
import java.util.*;

public class Main {
	public static class Points implements Comparable<Points>{
		int x, y, dist;
		public Points(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Points p) {
			if(this.dist != p.dist) {
				return this.dist-p.dist;
			}
			
			if(this.x != p.x) {
				return this.x - p.x;
			}
			
			return this.y - p.y;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Points> pq = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			pq.add(new Points(x, y, x+y));
		}
		
		for(int i=0; i<M; i++) {
			Points close = pq.poll();
			int nx = close.x + 2;
			int ny = close.y + 2;
			pq.add(new Points(nx, ny, nx+ny));
		}
		
		Points finalClose = pq.poll();
		sb.append(finalClose.x).append(" ").append(finalClose.y);
		System.out.println(sb);
	}

}
