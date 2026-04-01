import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		String word = br.readLine();
		int cnt = 0;
		int idx = 0;
		while(true) {
			if(idx == word.length()) break;
			boolean flag = false;
			
			for(int j=0; j<8; j++) {
				if(idx<=word.length()-2 && word.substring(idx, idx+2).equals(croatia[j])) {
					flag = true;
					idx += 2;
					break;
				}
				else if(idx<=word.length()-3 && word.substring(idx, idx+3).equals(croatia[j])) {
					flag = true;
					idx += 3;
					break;
				}
			}
			if(!flag) idx++;
			cnt++;
		}
		
		System.out.println(cnt);
	}

}
