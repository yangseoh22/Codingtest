import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt() * 2;
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        
        Arrays.sort(arr);
        int idxFin = n-1;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            int sum = arr[i] + arr[idxFin--];
            max = Math.max(sum, max);
        }
        
        System.out.println(max);
    }
}
