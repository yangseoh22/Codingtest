import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());  // N : 암호문 개수

        // 암호문별 가장 빈번한 알파벳 찾기
        for(int i = 0; i < N; i++) {
            String code = br.readLine();  // 암호문 입력
            int length = code.length();  // 암호문의 길이

            int[] cnt = new int[26];  // 알파벳 개수 저장 배열
            boolean duplicate = false;  // 가장 빈번한 알파벳이 복수 개인가?

            // 암호문 속 모든 문자의 개수를 확인
            for(int j = 0; j < length; j++) {
                char ch = code.charAt(j);

                // 공백이 아니면 개수 카운트
                if(ch!=' ') cnt[ch - 'a']++;
            }

            // 알파벳 개수 배열에서 가장 큰 숫자 찾기
            int max = 0;
            int idx = 0;
            for(int k = 0; k < 26; k++) {
                // 최댓값을 찾으면
                if(cnt[k] > max) {
                    max = cnt[k];  // 최댓값 갱신
                    idx = k;  // 인덱스 저장
                    duplicate = false;
                }
                // 현재 최댓값이랑 같은 값이라면,
                else if(cnt[k] == max){
                    duplicate = true;  // 중복이 있음
                }
            }

            // 중복이 있으면 '?' 출력, 없으면 해당 알파벳 출력
            if(duplicate) {
                sb.append("?").append("\n");
            }
            else{
                char result = (char)('a' + idx);  // 해당 아스키코드를 알파벳 변환
                sb.append(result).append("\n");
            }
        }

        System.out.println(sb);
    }
}