import java.io.*;
import java.util.*;

public class Main {
	public static class Node implements Comparable<Node>{
		int x, y, w;
		public Node(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node n) {
			return this.w-n.w;
		}
	}
	
	static int N, M;
	static final int INF = (int)1e9;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] map;
	static int[][] dist;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
	
		map = new int[N][M];
		dist = new int[N][M];
		for(int r=0; r<N; r++) {
			String line = br.readLine();
			for(int c=0; c<M; c++) {
				map[r][c] = line.charAt(c) - '0';
				dist[r][c] = INF;
			}
		}
		
		// (0, 0)에서 (N, M)으로
		dijk(0, 0);
		
		System.out.println(dist[N-1][M-1]);
	}
	private static void dijk(int startR, int startC) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(startR, startC, 0));
		dist[startR][startC] = 0;
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			int cx = curr.x;
			int cy = curr.y;
			int cw = curr.w;
			
			if(dist[cx][cy] != cw) continue;
			
			if(cx==N-1 && cy==M-1) break;
			
			for(int i=0; i<4; i++) {
				int nx = cx + dr[i];
				int ny = cy + dc[i];
				
				if(nx>=0 && ny>=0 && nx<N && ny<M) {
					int newDist = cw + map[nx][ny];
					if(dist[nx][ny] > newDist) {
						dist[nx][ny] = newDist;
						pq.add(new Node(nx, ny, newDist));
					}
				}
			}
		}
		
	}

}
