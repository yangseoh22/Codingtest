import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static int N, cX, cY, hX, hY;
	static ArrayList<int[]> guest;
	static boolean[] V;
	static int minDist;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			guest = new ArrayList<>();
			V = new boolean[N+2];
			minDist = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine());
			cX = Integer.parseInt(st.nextToken());
			cY = Integer.parseInt(st.nextToken());
			guest.add(new int[] {cX, cY});

			hX = Integer.parseInt(st.nextToken());
			hY = Integer.parseInt(st.nextToken());
			guest.add(new int[] {hX, hY});
			
			for(int i=0; i<N; i++) {
				int tX = Integer.parseInt(st.nextToken());
				int tY = Integer.parseInt(st.nextToken());
				guest.add(new int[] {tX, tY});
			}
			
			DFS(0, 0, 0);
			
			sb.append("#").append(t).append(" ").append(minDist).append("\n");
		}
		System.out.println(sb);
	}
	
	
	private static void DFS(int cnt, int lastIdx, int distSum) {
		if(distSum>=minDist) return;
		
		if(cnt == N) {
			int finalDist = distSum + calDist(lastIdx, 1);  // 마지막 고객과 집의 거리의 합
			minDist = Math.min(minDist, finalDist);
			return;
		}
		
		for(int i=2; i<N+2; i++) {
			if(!V[i]) {
				V[i] = true;
				DFS(cnt +1, i, distSum+calDist(lastIdx, i));
				V[i] = false;
			}
		}
	}


	private static int calDist(int i, int j) {
		int[] a = guest.get(i);
		int[] b = guest.get(j);
		
		int dist = Math.abs(a[0]-b[0])+Math.abs(a[1]-b[1]);
		
		return dist;
	}

}
