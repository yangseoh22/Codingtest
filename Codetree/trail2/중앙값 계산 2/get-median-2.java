import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] copy = new int[n];
        int idx = n-1;
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
            
            // 인덱스가 홀수 -> 짝수번째 수
            if(i % 2 != 0) continue;
            
            copy = copyArr(arr);
            Arrays.sort(copy);

            sb.append(copy[idx--]).append(" ");
        }
        
        System.out.println(sb);
    }

    private static int[] copyArr(int[] arr) {
        int[] c = new int[arr.length];
        
        for(int i=0; i<arr.length; i++) {
            c[i] = arr[i];
        }
        
        return c;
    }
}
