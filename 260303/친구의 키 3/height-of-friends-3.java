import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		PriorityQueue<Integer> q = new PriorityQueue<>();
		ArrayList<Integer>[] edges = new ArrayList[N + 1];
		int[] indegree = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			edges[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int taller = Integer.parseInt(st.nextToken());
			int shorter = Integer.parseInt(st.nextToken());

			edges[taller].add(shorter);
			indegree[shorter]++;
		}

		int cnt = 0; // 큐에 들어간 노드 개수
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				q.add(i);
				cnt++;
			}
		}

		while (!q.isEmpty()) {
			int now = q.poll();

			sb.append(now).append(" ");

			for (int i = 0; i < edges[now].size(); i++) {
				int next = edges[now].get(i);
				indegree[next]--;  // 인접 노드들의 차수 감소

				if (indegree[next] == 0) {
					q.add(next);
					cnt++;
				}

			}
		}
		
		if(N==cnt) System.out.println(sb);  // 사이클이 없었다면 위상정렬 맞음
		else System.out.println(-1);  // 사이클이 존재
	}

}
