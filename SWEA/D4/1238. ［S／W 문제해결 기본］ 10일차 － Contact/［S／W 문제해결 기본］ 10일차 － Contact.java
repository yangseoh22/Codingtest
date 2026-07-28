import java.util.*;
import java.io.*;

public class Solution {
    static int N;
    static ArrayList<Integer>[] graph;
    static int[] visited;
    static int maxNum;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = 10;
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            graph = new ArrayList[101];
            for(int i=1; i<101; i++){
                graph[i] = new ArrayList<>();
            }

            visited = new int[101];
            Arrays.fill(visited, -1);

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<len/2; i++){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph[from].add(to);
            }

            maxNum = start;
            bfs(start);

            int maxDepth = 0;
            for(int i=0; i<101; i++){
                if(maxDepth<visited[i]){
                    maxNum = i;
                    maxDepth = visited[i];
                }
                else if(maxDepth==visited[i]){
                    maxNum = Math.max(maxNum, i);
                }
            }

            sb.append("#").append(t).append(" ").append(maxNum).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = 0;

        while(!q.isEmpty()){
            int now = q.poll();

            for(int next : graph[now]){
                if(visited[next] == -1){
                    visited[next] = visited[now] + 1;
                    q.add(next);
                }
            }
        }
    }

}
