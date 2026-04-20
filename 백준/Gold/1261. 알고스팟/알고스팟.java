import java.util.*;
import java.io.*;

public class Main {
	static int[][] dist;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int[][] dist = new int[N][M];
		
		for(int r=0; r<N; r++) {
			String lines = br.readLine();
			for(int c=0; c<M; c++) {
				map[r][c] = lines.charAt(c) - '0';
			}
		}
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				dist[r][c] = Integer.MAX_VALUE;
			}
		}
		
		// 다익스트라 진행
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[0][0] = 0;
		pq.add(new Node(0, 0, 0));
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(now.d > dist[now.x][now.y]) continue;
			
			for(int i=0; i<4; i++) {
				int nx = now.x + dr[i];
				int ny = now.y + dc[i];
				
				if(nx>=0 && nx<N && ny>=0 && ny<M) {
					int newDist = dist[now.x][now.y] + map[nx][ny];
					if(dist[nx][ny]>newDist) {
						dist[nx][ny] = newDist;
						pq.add(new Node(nx, ny, newDist));
					}
				}
			}
		}

		sb.append(dist[N-1][M-1]);
		System.out.println(sb);
	}
	
	public static class Node implements Comparable<Node>{
		int x, y, d;
		public Node(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
		
		@Override
		public int compareTo(Node n){
			return this.d - n.d;
		}
	}
}
