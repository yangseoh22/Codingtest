import java.util.Scanner;
public class Main {
    static int max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        max = Integer.MIN_VALUE;
        findMax(n, arr);
        
        System.out.println(max);
	}

	private static int findMax(int n, int[] arr) {
		if(n==0) return max;
		
		if(arr[n-1]>max) max = arr[n-1];
		
		return findMax(n - 1, arr);
	}
}