import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int cnt = 0;
		
		for(int i=0; i<n; i++) {
			int[] check = new int[26]; // 알파벳 등장 여부
			char[] tmp = sc.next().toCharArray();
			
			char before = tmp[0];  // 바로 전 알파벳
			check[tmp[0]-'a'] = 1;
			
			boolean group = true;
			for(int j=1; j<tmp.length; j++) {
				char now = tmp[j]; // 현재 알파벳
				
				// 현재 알파벳이 이미 등장했고, 바로 전 등장이 아니라면 제외
				if(check[now-'a']==1 && before!=now) {
					group = false;
					break;
				}
				
				check[now-'a']=1;  // 현재 알파벳 등장했음을 알림
				before = now;  // 이전 알파벳 갱신
			}
			
			if (group) cnt++;
		}
		
		System.out.println(cnt);
	}

}
