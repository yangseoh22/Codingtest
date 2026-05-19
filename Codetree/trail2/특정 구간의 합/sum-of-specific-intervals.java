import java.io.*;
import java.util.*;

public class Main {
    public static int[] arr;
    public static int sum;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=0; i<M; i++) {
            sum = 0;

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            for(int j=x; j<=y; j++) {
                sum += arr[j-1];
            }
            sb.append(sum).append("\n");
        }
        
        System.out.println(sb);
    }

}
