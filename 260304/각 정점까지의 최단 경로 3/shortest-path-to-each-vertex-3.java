import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] adj;
	static boolean[] V;
	static int[] dist;
	static final int INF = (int) 1e9;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		adj = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(adj[i], INF);
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			adj[x][y] = Math.min(z, adj[x][y]);
		}

		V = new boolean[N + 1];
		dist = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			dist[i] = (int) 1e9;
		}

		dist[1] = 0;

		for (int i = 1; i <= N; i++) {
			int minIdx = -1;
			int minVal = INF;
			for (int j = 1; j <= N; j++) {
				if (!V[j] && dist[j] < minVal) {
					minVal = dist[j];
					minIdx = j;
				}
			}

			if (minIdx == -1)
				break;

			V[minIdx] = true;

			for (int j = 1; j <= N; j++) {
				if (!V[j] && adj[minIdx][j] != INF) {
					if (dist[j] > dist[minIdx] + adj[minIdx][j]) {
						dist[j] = dist[minIdx] + adj[minIdx][j];
					}
				}
			}
		}

		for (int i = 2; i <= N; i++) {
			if (dist[i] == INF) {
				sb.append("-1\n"); // 도달할 수 없는 경우 -1 출력
			} else {
				sb.append(dist[i]).append("\n");
			}
		}

		System.out.println(sb);
	}

}
