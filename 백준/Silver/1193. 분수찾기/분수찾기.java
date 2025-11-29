import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
	
		// 각 분수를 y/x = (y좌표, x좌표) 라고 생각
		int x=1, y=1;  // x좌표, y좌표
		int dir = -1;  // 방향
		
		for(int i=2; i<=n; i++) {
			if(y==1 && dir==-1) {
				x++;
				dir = 1;  // 방향 반전
			}
			else if(x==1 && dir==1){
				y++;
				dir = -1; // 방향 전환
			}
			else if(dir==1){
				y++; x--;
			}
			else {
				y--; x++;
			}
		}
		System.out.println(y+"/"+x);
	}

}
