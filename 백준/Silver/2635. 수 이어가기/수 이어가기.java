import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());  // 첫 번째 수

        // 규칙으로 만든 수열 중 최대 크기를 저장할 배열
        ArrayList<Integer> result = new ArrayList<>();

        // 최대 크기를 비교하기 위한 배열
        ArrayList<Integer> tmp = new ArrayList<>();

        // 두 번째 수에 들어갈 수 있는 모든 수를 확인
        // N보다 큰 수는 모두 3에서 끝나므로 N+1까지 확인
        // 최대 개수의 수가 만들어지는 배열 찾기
        int max = 0;
        for (int i = 1; i <= N+1; i++) {
            tmp = checking(N, i);

            if (tmp.size() > max) {
                max = tmp.size();
                result = tmp;
            }
        }

        sb.append(max).append("\n");
        for(int n : result){
            sb.append(n+" ");
        }
        
        System.out.println(sb);
    }

    // 규칙으로 만들어지는 수를 세는 함수
    public static ArrayList<Integer> checking (int N, int n){
        int one = N;  // 앞의 앞의 수
        int two = n;  // 앞의 수
        int now = one-two;

        // 규칙으로 만든 수들을 저장할 배열
        ArrayList<Integer> list = new ArrayList<>();

        // 앞의 앞의 수와 앞의 수는 먼저 배열에 추가
        list.add(one);
        list.add(two);

        // 세번째 수부터는 규칙을 만족하면 추가
        while(now>=0){
            list.add(now);

            one = two;
            two = now;
            now = one - two;
        }

        return list;
    }
}