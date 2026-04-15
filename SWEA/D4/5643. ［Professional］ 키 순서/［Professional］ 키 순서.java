import java.util.*;
import java.io.*;

public class Solution {
	static final int MAX = 1000000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());

			int[][] dist = new int[N + 1][N + 1];

			// 거리 배열 초기화
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= N; c++) {
					dist[r][c] = MAX;
				}
				dist[r][r] = 0;
			}

			// 연결 내용 추가
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				dist[from][to] = 1;
			}
			
			// 플로이드 워셜로 연결된 노드 표시
			for (int k = 1; k <= N; k++) {
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {
						dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
					}
				}
			}
			
			// 행>열과 열>행을 같이 봤을 때 둘 다 MAX인 곳이 없으면 자신의 키를 알 수 있음
			int result = 0;
			for (int r = 1; r <= N; r++) {
				boolean flag = false;
				for (int c = 1; c <= N; c++) {
					if (dist[r][c] != MAX || dist[c][r] != MAX) {
						flag = true;
					}
					else {
						flag = false;
						break;
					}
				}
				if(flag) result++;
			}
			
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

}
