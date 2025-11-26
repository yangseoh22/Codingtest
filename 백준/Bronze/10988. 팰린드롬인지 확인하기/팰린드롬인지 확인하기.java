import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		
		String str = sc.nextLine();
		char[] word = str.toCharArray();
		
		int isTrue = 1;  // 팰린드롬 여부
		int front = 0;  //시작 포인터
		int end = word.length-1;  //끝 포인터
		while(front<=end) {
			// 팰린드롬이 아님
			if(word[front]!=word[end]) isTrue = 0;
			
            // 포인터 이동
			front++;
			end--;
		}
		
		System.out.println(isTrue);
	}

}
