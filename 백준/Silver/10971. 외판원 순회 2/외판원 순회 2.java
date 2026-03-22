/*
 * 시간 : 
 * 메모리 : 
 * 전략 : 백트래킹 (순열)
 * 1. 인덱스로 순열 생성
 * 2. 해당 순열의 순서에 따라 i와 i+1 번째 요소의 비용을 더하기
 * 3. 마지막 도시에서 처음 도시로 가는 비용까지 더해주기
 * 4. 최소 비용인 경우 갱신
 */

import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] W;
	static int[] arr;
	static boolean[] V;
	static int minCost = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		W = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		arr = new int[N];
		V = new boolean[N];
		perm(0);
		
		System.out.println(minCost);
	}
	private static void perm(int idx) {
		if(idx == N) {
			// 비용 계산
			calCost();
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!V[i]) {
				arr[idx] = i;
				V[i] = true;
				perm(idx+1);
				V[i] = false;
			}
		}
	}
	private static void calCost() {
		// 처음 ~ 마지막 도시 비용
		int sumCost = 0;
		for(int i=0; i<N-1; i++) {
			int now = arr[i];
			int next = arr[i+1];
			
			
			if(W[now][next] == 0) return;
			sumCost += W[now][next];
		}
		
		// 마지막 도시에서 처음 도시로 돌아오는 비용
		if(W[arr[N-1]][arr[0]] == 0) return;		
		sumCost += W[arr[N-1]][arr[0]];
		
		minCost = Math.min(minCost, sumCost);
	}
	
}
