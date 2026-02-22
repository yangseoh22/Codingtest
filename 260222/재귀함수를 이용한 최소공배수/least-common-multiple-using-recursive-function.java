import java.util.Scanner;

public class Main {
    	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        int nowLcm = 1;
        for(int i=0; i<n; i++) {
        	nowLcm = lcm(nowLcm, arr[i]);
        }
        
        System.out.println(nowLcm);
	}
	
	// 최소 공배수 구하기
	private static int lcm(int nowLcm, int i) {
		return (nowLcm * i) / gcd(nowLcm, i);
	}

	// 최대 공약수 구하기
	private static int gcd(int a, int b) {
	    if (b == 0) return a; // 나머지가 0이면 a가 GCD
	    return gcd(b, a % b); // b와 'a를 b로 나눈 나머지'로 다시 호출
	}
}