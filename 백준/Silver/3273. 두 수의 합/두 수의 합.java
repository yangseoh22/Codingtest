import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());  // 수열의 크기

//        *** split을 이용하여 수열 입력 받기 ***
//        String tmp = br.readLine();  // 수열을 하나의 문자열로 입력 받음
//        String[] tmps = tmp.split(" ");  // 공백을 기준으로 문자열 배열에 나눠 저장
//
//        // 문자열 배열을 정수 배열로 변환
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = Integer.parseInt(tmps[i]);
//        }


//        *** Arrays.stream()으로 수열 입력 받기 ***
//        int[] numbers = Arrays.stream(br.readLine().split(" "))
//                .mapToInt(Integer::parseInt)
//                .toArray();
//
//        for(int num : numbers){
//            System.out.println(num);
//        }


//      *** StringTokenizer을 이용하여 수열 입력 받기 ***
        StringTokenizer st = new StringTokenizer(br.readLine());  // 정수 입력

        int[] arr = new int[n];  // 크기가 n인 배열 생성

        for (int i = 0; i < n; i++) {  // 토큰을 옮겨가며 요소별로 저장
            arr[i] = Integer.parseInt(st.nextToken());
        }
//        * 토큰을 저장하는 또다른 방법 (hasMoreTokens이용) *
//        int idx = 0;
//        while(st.hasMoreTokens()){
//            arr[idx++] = Integer.parseInt(st.nextToken());
//        }


        int x = Integer.parseInt(br.readLine());  // 합의 기준으로 사용할 수
        int cnt = 0;  // 카운트 변수

        Arrays.sort(arr);  // 오름차순 정렬

        int left = 0;  // 왼쪽 포인터
        int right = arr.length - 1;  // 오른쪽 포인터

        while(left < right) {
            if(arr[left] + arr[right] > x ) { right--; }  // 합을 줄이기 위해 right 감소
            else if(arr[left] + arr[right] < x ) { left++; }  // 합을 늘리기 위해 left 증가
            else {
                cnt++;  // 조건을 만족하므로 카운팅

                // 다른 쌍을 찾기 위해 계속 진행
                left++;
                right--;
            }
        }

        System.out.println(cnt);
    }
}