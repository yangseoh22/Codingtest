import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int K, N;
	static ArrayList<Integer> arr;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new ArrayList<>();
		
		// 중복 순열
		perm(0);
		
		System.out.println(sb);
	}
	private static void perm(int idx) {
		if(idx==N) {
			for(int a : arr) {
				sb.append(a).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<=K; i++) {
			// 같은 숫자가 3번 나오지 않을 때 넣기
			if(idx>=2 && arr.get(arr.size()-1)==i && arr.get(arr.size()-1)==arr.get(arr.size()-2)) continue;
			
			arr.add(i);
			perm(idx + 1);
			arr.remove(arr.size()-1);
		}
	}

}
