import java.io.*;
import java.util.*;

public class Main {
	static int N, M, semester;
	static ArrayList<Integer>[] graph;
	static int[] degree;
	static Queue<int[]> q = new LinkedList<>();
	static int[] s;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		degree = new int[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			graph[s].add(e);
			degree[e]++;
		}

		for (int i = 1; i <= N; i++) {
			if (degree[i] == 0) {
				q.add(new int[] { i, 1 });
			}
		}
		
		s = new int[N+1];
		while (!q.isEmpty()) {
			int[] now = q.poll();
			s[now[0]] = now[1];
			for (int next : graph[now[0]]) {
				degree[next]--;

				if (degree[next] == 0) {
					q.add(new int[] { next, now[1] + 1 });
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			sb.append(s[i]).append(" ");
		}
		System.out.println(sb);
	}

}
