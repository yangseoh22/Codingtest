import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[9];
		int sum = 0;
		for(int i=0; i<9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		
		int x = 0;
		int y = 0;
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				if(i!=j) {
					if(sum-arr[i]-arr[j] == 100) {
						x = i;
						y = j;
					}
				}
			}
		}
		
		int[] newArr = new int[7];
		int idx = 0;
		for(int i=0; i<9; i++) {
			if(i==x || i==y) continue;
			newArr[idx++] = arr[i];
		}
		
		Arrays.sort(newArr);
		for(int i=0; i<7; i++) {
			System.out.println(newArr[i]);
		}
	}

}
