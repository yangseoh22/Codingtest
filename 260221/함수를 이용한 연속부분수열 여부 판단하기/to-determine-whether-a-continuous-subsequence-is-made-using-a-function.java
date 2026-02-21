import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int[] a = new int[n1];
        int[] b = new int[n2];
        for (int i = 0; i < n1; i++)
            a[i] = sc.nextInt();
        for (int i = 0; i < n2; i++)
            b[i] = sc.nextInt();

        if(checkArr(a, b, n1, n2)) System.out.println("Yes");
        else System.out.println("No");
	}

	private static boolean checkArr(int[] a, int[] b, int na, int nb) {
		int cnt, bIdx;
		for(int i=0; i<=na-nb; i++) {
			cnt = 0;
			bIdx = 0;
			for(int j=i; j<i+nb; j++) {
				if(a[j]!=b[bIdx++]) break;
				cnt++;
			}
			if(cnt == nb) {
				return true;
			}
		}
		return false;
	}
}