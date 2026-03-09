import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] uf;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 서로소 집합 생성
		uf = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			uf[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int cmd = Integer.parseInt(st.nextToken());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (cmd == 0)
				union(a, b);
			else {
				// find() 결과가 같으면 같은 집합
				sb.append(find(a) == find(b) ? 1 : 0).append("\n");
			}
		}
		
		System.out.println(sb);
	}

	private static int find(int x) {
		if (uf[x] == x)
			return x;
		int rootNode = find(uf[x]);
		uf[x] = rootNode;
		return rootNode;
	}

	private static void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		uf[rootX] = rootY;
	}
}
