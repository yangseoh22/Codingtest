import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for(int t=1; t<=TC; t++) {
			int N = Integer.parseInt(br.readLine());
			
			List<Point> arr = new ArrayList<>();
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				arr.add(new Point(x, y));
			}
			
			int maxWidth = Integer.MIN_VALUE;
			for(int i=0; i<arr.size(); i++) {
				for(int j=0; j<arr.size(); j++) {
					if(i==j) continue;
					
					if((arr.get(i).x != arr.get(j).x) && (arr.get(i).y == arr.get(j).y)) {
						for(int k=0; k<arr.size(); k++) {
							if(k==i || k==j ) continue;
							
							// 가로 계산
							int garo = Math.abs(arr.get(i).x - arr.get(j).x);
							int sero = 0;
							int width = 0;
							
							// i점과 비교 - 세로 계산
							if((arr.get(i).x == arr.get(k).x) && (arr.get(i).y != arr.get(k).y)) {
								sero = Math.abs(arr.get(i).y-arr.get(k).y);
								width = garo * sero;  // 문제에서 다시 2를 곱하라 했으므로
							}
							// j점과 비교 - 세로 계산
							else if((arr.get(j).x == arr.get(k).x) && (arr.get(j).y != arr.get(k).y)) {
								sero = Math.abs(arr.get(j).y-arr.get(k).y);
								width = garo * sero;
							}
							
							maxWidth = Math.max(maxWidth, width);
						}
					}
				}
			}
			sb.append(maxWidth).append("\n");
		}
		System.out.println(sb);
	}

	static public class Point {
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
