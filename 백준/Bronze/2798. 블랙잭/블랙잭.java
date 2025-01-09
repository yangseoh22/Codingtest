import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());  // (3<=N<=100)
        int M = Integer.parseInt(st.nextToken());  // (10<=M<=300,000)

        // N장의 수를 저장
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 순서는 상관없이 N장의 카드에서 3장을 뽑는 모든 경우를 참조해
        // 그 합의 M보다 작은 최댓값을 계산
        int max = 0;
        for (int x = 0; x <= N - 3; x++) {
            for (int y = x + 1; y <= N - 2; y++) {
                for (int z = y + 1; z <= N - 1; z++) {
                    int now = arr[x] + arr[y] + arr[z];

                    // 선택한 세 카드의 합이 조건을 만족하면 갱신
                    if (now <= M && max < now) max = now;
                }
            }
        }

        System.out.println(max);
    }
}