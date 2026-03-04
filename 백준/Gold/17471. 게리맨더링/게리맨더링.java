import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] population;
	static ArrayList<Integer>[] arr;
	static boolean[] selected;
	static int minDiff = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		population = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		
		// 그래프 생성
		arr = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			
			for(int j=0; j<cnt; j++) {
				arr[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		selected = new boolean[N+1];
		divide(0);
		
		// 최소 차이가 갱신 되었으면 그 값을, 아니라면 -1 출력
		System.out.println(minDiff==Integer.MAX_VALUE? -1 : minDiff);
	}

	// 두 선거구 조합 찾기
	private static void divide(int idx) {
		if(idx == N) {
			check();
			return;
		}
		
		selected[idx] = true;
		divide(idx + 1);
		
		selected[idx] = false;
		divide(idx + 1);
	}
	
	// 유효성 검사
	private static void check() {
		
		// 각 팀별 리스트 생성
		ArrayList<Integer> teamA = new ArrayList<>();
		ArrayList<Integer> teamB = new ArrayList<>();
		
		for(int i=1; i<=N; i++) {
			if(selected[i]) teamA.add(i);
			else teamB.add(i);
		}
		
		// 1. 사이즈가 1이상인가?
		if(teamA.isEmpty() || teamB.isEmpty()) return;
		
		// 2. 모두 연결되어 있는가? + 인구 수 차이 계산
		int sumA = 0;
		int sumB = 0;
		if(isConnected(teamA) && isConnected(teamB)) {
			for(int a : teamA) sumA += population[a];
			for(int b : teamB) sumB += population[b];
			
			minDiff = Math.min(minDiff, Math.abs(sumA-sumB));
		}
	}

	// 같은 팀끼리 연결되었는가
	private static boolean isConnected(ArrayList<Integer> list) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		
		int start = list.get(0);
		q.add(start);
		visited[start] = true;
		
		int cnt = 1;
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			for(int next : arr[curr]) {
				if(list.contains(next) && !visited[next]) {
					visited[next] = true;
					q.add(next);
					
					cnt++;
				}
			}
		}
		
		return cnt == list.size();
	}
	
	
}
