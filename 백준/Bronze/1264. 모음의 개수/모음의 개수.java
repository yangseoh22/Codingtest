import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();  //문장 입력

        while(!str.equals("#")){  // 종료 조건
            int cnt = 0;
            
            // 문자열의 각 문자를 추출해 모음 체크
            for(int i = 0; i < str.length(); i++){
                char ch = str.charAt(i);  // 문자열의 각 문자별로 추출
                ch = Character.toLowerCase(ch);  // 모두 소문자로 변환

                // 모음이면 cnt 증가
                if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
            str = br.readLine();  //문장 입력
        }

        System.out.println(sb);
    }
}