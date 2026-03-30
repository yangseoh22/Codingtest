import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int cnt = -1;
		if (N % 5 == 0)
			cnt = N / 5;
		else if (N % 3 == 0)
			cnt = N / 3;

		int five = 0;
		while (N >= 5) {
			int three = 0;

			N = N - 5;
			five++;

			if (N % 3 == 0) {
				three = N / 3;
				if (cnt != -1)
					cnt = Math.min(cnt, five + three);
				else
					cnt = five + three;
			}
		}

		System.out.println(cnt);
	}

}
