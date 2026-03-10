import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge>{
	int start, end, weight;
	Edge(int start, int end, int weight){
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Edge o) {
		return Integer.compare(this.weight, o.weight);
	}
}

public class Solution {
	static Edge[] edges;
	static int[] node;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			edges = new Edge[E];
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				
				edges[i] = new Edge(s, e, w);
			}
			
			Arrays.sort(edges);
			
			node = new int[V+1];
			for(int i=1; i<=V; i++) {
				node[i] = i;
			}
			
			int cnt = 0;
			long result = 0;
			for(Edge ed : edges) {
				if(union(ed.start, ed.end)) {
					cnt++;
					result += ed.weight;
					if(cnt == V-1) break;
				}
			}
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	private static boolean union(int start, int end) {
		int startN = find(node[start]);
		int endN = find(node[end]);
		
		if(startN == endN) {
			return false;
		}
		node[startN] = endN;
		return true;
	}
	private static int find(int x) {
		if(node[x]==x) return x;
		int rootN = find(node[x]);
		node[x] = rootN;
		return rootN;
	}	

}
