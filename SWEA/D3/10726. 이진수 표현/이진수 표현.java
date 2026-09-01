import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        for(int t=1; t<=TC; t++){
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // M의 마지막 N자리 비트가 1인지 확인
            boolean result = true;
            for(int i=0; i<N; i++){
                int bitOn = M & ( 1 << i );

                // 0이라면 꺼져있는 것이므로 종료
                if(bitOn == 0){
                    result = false;
                    break;
                }
            }

            if(result) sb.append("ON").append("\n");
            else sb.append("OFF").append("\n");
        }
        System.out.println(sb);
    }
}
