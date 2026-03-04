import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
	int end;
	int w;

	public Node(int end, int w) {
		this.end = end;
		this.w = w;
	}
};

class Element implements Comparable<Element> {
	int dist;
	int idx;

	public Element(int dist, int idx) {
		this.dist = dist;
		this.idx = idx;
	}

	@Override
	public int compareTo(Element e) {
		return this.dist - e.dist;
	}
}

public class Main {

	static int[] dist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 정점 수
		int M = Integer.parseInt(st.nextToken()); // 간선 수

		int K = Integer.parseInt(br.readLine()); // 시작 정점

		ArrayList<Node>[] graph = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()); // 시작 노드
			int e = Integer.parseInt(st.nextToken()); // 종료 노드
			int w = Integer.parseInt(st.nextToken()); // 가중치

			graph[s].add(new Node(e, w));
			graph[e].add(new Node(s, w));
		}

		PriorityQueue<Element> pq = new PriorityQueue<>();
		dist = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			dist[i] = (int) 1e9;
		}

		dist[K] = 0;
		pq.add(new Element(0, K));

		while (!pq.isEmpty()) {
			Element curr = pq.poll();
			int minDist = curr.dist;
			int minIdx = curr.idx;

			if (minDist != dist[minIdx])
				continue;

			for (Node next : graph[minIdx]) {
				int cost = dist[minIdx] + next.w;
				if (cost < dist[next.end]) {
					dist[next.end] = cost;
					pq.add(new Element(cost, next.w));
				}
			}
		}

		boolean isAll = true;
		for (int i = 1; i <= N; i++) {
			if (dist[i] == (int) 1e9)
				isAll = false;
		}

		for (int i = 1; i <= N; i++) {
            if (dist[i] == (int)1e9) sb.append("-1").append("\n");
            else sb.append(dist[i]).append("\n");
        }

		System.out.println(sb);
	}

}
