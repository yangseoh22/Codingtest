public class Main {

	public static void main(String[] args) {
		boolean check[] = new boolean[10001];
		
		for(int i=1; i<=10000; i++) {
			int s = i;  // 생성자
			
			// 각 자릿수를 더해줌
			char[] tmp = String.valueOf(i).toCharArray();
			for(int j=0; j<tmp.length; j++) {
				s += Integer.parseInt(String.valueOf(tmp[j]));
			}
			
			// 10000이하의 결과가 나오면 저장
			if(s<10001) check[s] = true;
		}
		
		for(int i=1; i<=10000; i++) {
			if(!check[i]) System.out.println(i);
		}
	}

}
