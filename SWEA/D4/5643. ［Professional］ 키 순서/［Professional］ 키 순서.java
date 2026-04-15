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

			int[][] taller = new int[N + 1][N + 1];
			int[][] shorter = new int[N + 1][N + 1];

			// 거리 배열 초기화
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= N; c++) {
					taller[r][c] = MAX;
					shorter[r][c] = MAX;
				}
				taller[r][r] = 0;
				shorter[r][r] = 0;
			}

			// 연결 내용 추가
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				taller[from][to] = 1;
				shorter[to][from] = 1;
			}
			
			// 플로이드 워셜로 연결된 노드 표시
			for (int k = 1; k <= N; k++) {
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {
						taller[i][j] = Math.min(taller[i][j], taller[i][k] + taller[k][j]);
						shorter[i][j] = Math.min(shorter[i][j], shorter[i][k] + shorter[k][j]);
					}
				}
			}
			
			// 두 배열을 같이 봤을 때 각 행에 대해 둘 다 MAX인 곳이 없으면 자신의 키를 알 수 있음
			int result = 0;
			for (int r = 1; r <= N; r++) {
				boolean flag = false;
				for (int c = 1; c <= N; c++) {
					if (taller[r][c] != MAX || shorter[r][c] != MAX) {
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
