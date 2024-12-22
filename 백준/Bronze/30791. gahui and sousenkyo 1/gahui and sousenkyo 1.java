import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 16~20위 점수
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        // 카운트 대상의 최고 점수
        int x = a - 1000;
        int cnt = 0;

        // 다른 순위가 해당 점수 이하인 경우를 카운트
        if(b>=x) cnt++;
        if(c>=x) cnt++;
        if(d>=x) cnt++;
        if(e>=x) cnt++;

        System.out.println(cnt);
    }
}