import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());  // 정수의 개수
        int[] stack = new int[K];  // 스택 생성

        // 조건에 따른 스택에 수 쌓기
        int idx = 0;  // 다음 원소가 들어갈 인덱스 위치
        for(int i = 0; i < K; i++){
            int now = Integer.parseInt(br.readLine());  // 정수 입력 받기

            if(now != 0) stack[idx++] = now;  // '0'이 아니면 배열에 값 저장, 인덱스 증가
            else idx--;
        }

        // 스택에 남은 수들의 합
        int sum = 0;
        for(int i = 0; i < idx; i++) {
            sum += stack[i];
        }

        System.out.println(sum);
    }
}