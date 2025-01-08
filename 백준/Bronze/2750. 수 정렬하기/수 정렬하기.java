import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());  //수의 개수
        int[] arr = new int[N];

        // 배열 입력
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 반복을 통한 오름차순 정렬
        int k=1;  //정렬 종료된 요소 개수
        /*
        한 번 비교당 두 개 요소를 비교하므로
        마지막 요소는 생각 안해도 되기때문에
        N-1번만 반복
        */
        for(int i = 0; i < N-1; i++){
            for(int j = 0; j < N-k; j++){
                // 이전 원소가 뒤 원소보다 큰 경우 교환
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }
            }
            k++;
        }

        // 배열 출력
        for(int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }
    }
}
