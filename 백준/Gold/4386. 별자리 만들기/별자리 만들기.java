import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] uf;
	static ArrayList<double[]> tmp;
	static ArrayList<Edge> nodes;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		nodes = new ArrayList<>();
		tmp = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			double s = Double.parseDouble(st.nextToken());
			double e = Double.parseDouble(st.nextToken());
			tmp.add(new double[] {s, e});
		}
		
		// 별 i와 별 j의 거리 계산
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				double x = Math.pow(tmp.get(i)[0] - tmp.get(j)[0], 2);
				double y = Math.pow(tmp.get(i)[1] - tmp.get(j)[1], 2);
				double w = Math.sqrt(x+y);
				
				nodes.add(new Edge(i, j, w));
			}
		}
		
		
		// Kruskal 진행
		Collections.sort(nodes);
		
		uf = new int[N];
		for(int i=0; i<N; i++) {
			uf[i] = i;
		}
		
		double total = 0;
		int cnt = 0;
		for(Edge e : nodes) {
			if(find(e.start) != find(e.end)) {
				union(e.start, e.end);
				total += e.weight;
				cnt++;
				
				if(cnt == N-1) break;
			}
		}
		
		System.out.printf("%.2f", total);
	}
	
	private static void union(int x, int y) {
		int nx = find(x);
		int ny = find(y);
		
		uf[nx] = ny;
	}

	private static int find(int p) {
		if(uf[p] == p) return p;
		int newN = find(uf[p]);
		uf[p] = newN;
		return newN;
	}

	public static class Edge implements Comparable<Edge>{
		int start, end;
		double weight;
		public Edge(int start, int end, double weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.weight, o.weight);
		}
	}
}
