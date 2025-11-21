import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		int[] arr = new int[n+1];
		
		// n이하의 소수를 모두 구한 뒤, 마지막에 m이상만 출력하기
		// 인덱스 배열 생성
		for(int i=1; i<=n; i++) {
			arr[i] = i;
		}
		
		for(int j=2; j<=Math.sqrt(n); j++) {
			// 이미 소수가 아님을 판정했으니 무시
			if(arr[j]==0) continue;
			
			// j의 배수를 모두 삭제
			for(int k=j+j; k<=n; k=k+j) {
				arr[k] = 0;
			}
		}
		
		// 제거되지 않은 m이상의 소수 모두 출력
        // 1은 소수가 될 수 없음을 유의
		for(int i=m; i<=n; i++) {
			if(i==1) continue;
            if(arr[i]!=0) System.out.println(arr[i]);
		}
	}

}
