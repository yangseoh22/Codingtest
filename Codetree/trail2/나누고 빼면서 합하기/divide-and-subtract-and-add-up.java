import java.io.*;
import java.util.*;

public class Main {
    public static int sum;
    public static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        sum += arr[M-1];
        if(M != 1) {
            solve(M);
        }
        
        System.out.println(sum);
    }

    private static void solve(int m) {
        if(m % 2 == 0) m /= 2;
        else m--;
        
        sum += arr[m-1];

        if(m == 1) return;

        solve(m);
    }

}
