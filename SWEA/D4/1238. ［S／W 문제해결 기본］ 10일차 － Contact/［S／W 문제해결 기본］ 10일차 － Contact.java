import java.util.*;
import java.io.*;

public class Solution {
    static ArrayList<Integer>[] graph;
    static int visited[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int TC = 10;
        for(int t=1; t<=TC; t++){
            graph = new ArrayList[101];
            for(int i=0; i<101; i++){
                graph[i] = new ArrayList<>();
            }
            visited = new int[101];

            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            // 연락 그래프 생성
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<len/2; i++){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph[from].add(to);
            }

            BFS(start);

            int maxDepth = 0;
            int result = start;
            for(int i=0; i<101; i++){
                if(maxDepth <= visited[i]){
                    result = i;
                    maxDepth = visited[i];
                }
            }

            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static void BFS(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = 0;

        while(!q.isEmpty()){
            int curr = q.poll();

            for(int next : graph[curr]){
                if(visited[next] == 0){  // 방문하지 않은 곳이라면
                    visited[next] = visited[curr] + 1;
                    q.add(next);
                }
            }
        }
    }
}
