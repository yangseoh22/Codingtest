import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Edge>[] arr;
	static int N, M;
	static Edge[] edgeList;
	static int[] uf;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		edgeList = new Edge[M];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(start, end, weight);
		}
		
		Arrays.sort(edgeList);

		uf = new int[N+1];
		int totalW = 0;
		int edgeCnt = 0;
		for(int i=1; i<=N; i++) {
			uf[i] = i;
		}
		
		for(Edge edge : edgeList) {
			if(union(edge.from, edge.to)) {
				totalW += edge.weight;
				edgeCnt++;
				
				if(edgeCnt == N-1) break;
			}
		}

		System.out.println(totalW);
	}
	
	private static boolean union(int from, int to) {
		int nodeF = find(from);
		int nodeT = find(to);
		
		if(nodeF == nodeT) return false;
		
		uf[nodeF] = nodeT;
		return true;
	}

	private static int find(int x) {
		if(uf[x] == x) return x;
		int newN = find(uf[x]);
		uf[x] = newN;		
		return newN;
	}

	public static class Edge implements Comparable<Edge>{
		int from, to, weight;
		
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge e) {
			return this.weight - e.weight;
		}
	}
}
