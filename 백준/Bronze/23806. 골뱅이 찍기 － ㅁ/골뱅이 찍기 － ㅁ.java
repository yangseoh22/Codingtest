import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // n 입력
        int n = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n; i++) {  // n개의 줄
            for(int j = 1; j <= 5*n; j++) {  // 한 줄에 5*n개의 골뱅이
                sb.append("@");
            }
            sb.append("\n");
        }

        // 중간의 5*n-2*n=3n개의 줄
        for(int i = 1; i <= 3*n; i++) {
            // 한 줄의 처음에는 n개의 골뱅이
            for(int j = 1; j <= n; j++) {
                sb.append("@");
            }

            // 중간에는 3*n개의 공백
            for(int k = 1; k <= 3*n; k++) {
                sb.append(" ");
            }

            // 한 줄의 끝에는 n개의 골뱅이
            for(int p = 1; p <= n; p++) {
                sb.append("@");
            }

            sb.append("\n");
        }

        for(int i = 1; i <= n; i++) {  // n개의 줄
            for(int j = 1; j <= 5*n; j++) {  // 한 줄에 5*n개의 골뱅이
                sb.append("@");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}