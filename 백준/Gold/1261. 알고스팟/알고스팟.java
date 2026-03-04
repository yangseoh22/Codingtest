import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map, dist;
	static int minDist = Integer.MAX_VALUE;
	static final int INF = Integer.MAX_VALUE;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		dist = new int[N+1][M+1];
		
		for(int r=1; r<=N; r++) {
			String str = br.readLine();
			for(int c=1; c<=M; c++) {
				map[r][c] = str.charAt(c-1) - '0';
			}
		}
		
		for(int r=1; r<=N; r++) {
			for(int c=1; c<=M; c++) {
				dist[r][c] = INF;
			}
		}
		
		// 시작점(1, 1)에서 (N, M) 까지 가는 최소 거리(가중치)
		dist[1][1] = 0;
		dijk(1, 1);
		
		System.out.println(dist[N][M]);
	}
	
	private static class Node implements Comparable<Node>{
		int x, y, d;
		
		public Node(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
		
		// 우선순위 큐가 더 작은 비용 판단
		@Override
		public int compareTo(Node o) {
			return this.d - o.d;
		}
	}
	
	private static void dijk(int r, int c) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		
		dist[r][c] = 0;
		q.add(new Node(r, c, 0));
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			
			if(curr.d > dist[curr.x][curr.y]) continue;
			
			for(int i=0; i<4; i++) {
				int nr = curr.x + dr[i];
				int nc = curr.y + dc[i];
				
				if(nr>=1 && nc>=1 && nr<=N && nc<=M) {
					int nextD = curr.d + map[nr][nc];
					
					if(dist[nr][nc] > nextD) {
						dist[nr][nc] = nextD;
						q.offer(new Node(nr, nc, nextD));
					}
				}
			}
		}
	}
	
}
