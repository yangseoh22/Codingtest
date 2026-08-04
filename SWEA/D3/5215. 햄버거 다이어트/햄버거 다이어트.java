import java.util.*;
import java.io.*;

public class Solution {
    static int L, N;
    static int maxScore;
    static int[][] menu;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            menu = new int[N][2];
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                // 메뉴별 점수와 칼로리
                menu[i][0] = Integer.parseInt(st.nextToken());  // 점수
                menu[i][1] = Integer.parseInt(st.nextToken());  // 칼로리
            }

            // 최대 점수
            maxScore = 0;

            // 메뉴 조합 생성
            findCombi(0, 0, 0);

            sb.append("#").append(t).append(" ").append(maxScore).append("\n");
        }
        System.out.print(sb);
    }

    private static void findCombi(int idx, int score, int cal) {
        // 탐색 종료
        if (cal > L) {
            return;
        }

        // 모든 재료를 다 확인한 경우
        if (idx == N) {
            maxScore = Math.max(maxScore, score);
            return;
        }

        // 선택하는 경우
        findCombi(idx + 1, score + menu[idx][0], cal + menu[idx][1]);

        // 선택하지 않는 경우
        findCombi(idx + 1, score, cal);
    }

}
