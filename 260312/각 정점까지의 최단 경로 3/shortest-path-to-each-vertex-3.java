import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] adj = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			adj[s][e] = w;
		}

		int[] dist = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			dist[i] = (int) 1e9;
		}
		// 시작 정점 1
		dist[1] = 0;

		boolean[] visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			int minIdx = -1;
			for (int j = 1; j <= N; j++) {
				if (visited[j])
					continue;

				if (minIdx == -1 || dist[minIdx] > dist[j]) {
					minIdx = j;
				}
			}
			visited[minIdx] = true;

			for (int j = 1; j <= N; j++) {
				if (adj[minIdx][j] == 0)
					continue;

				dist[j] = Math.min(dist[j], dist[minIdx] + adj[minIdx][j]);
			}
		}

		if (dist[N] == (int) 1e9) {
			sb.append(-1);
		} else {
			for (int i = 1; i <= N; i++) {
				if (i == 1)
					continue;
				sb.append(dist[i]).append("\n");
			}
		}
		System.out.println(sb);
	}
}
