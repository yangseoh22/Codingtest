import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] x2 = new int[n];

        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
        }
        // Please write your code here.
        int[] line = new int[201];
        for (int i = 0; i < n; i++) {
            int start = x1[i];
            int end = x2[i];

            for(int j=start; j<end; j++){
                line[j+100]++;
            }
        }

        int max = 0;
        for (int i = 0; i < 201; i++) {
            if(max<line[i]) max = line[i];
        }
        System.out.println(max);
    }
}