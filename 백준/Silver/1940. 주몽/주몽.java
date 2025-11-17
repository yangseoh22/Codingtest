import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] tmp  = new int[n];
		
		// 소유한 재료 번호 입력
		for(int i=0; i<n; i++) {
			tmp[i] = sc.nextInt();
		}
		
        // 오름차순 
		Arrays.sort(tmp);
		
		int cnt = 0;
		int start = 0;
		int end = n-1;
        
        // 투 포인터로 합계 비교
		while(start<end) {
			if(tmp[start]+tmp[end]<m) {
				start++;
			}
			else if(tmp[start]+tmp[end]>m) {
				end--;
			}
			else {
				cnt++;
				start++;
				end--;
			}
		}
		
		System.out.println(cnt);
	}
}