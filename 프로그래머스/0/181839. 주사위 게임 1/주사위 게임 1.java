class Solution {
    public int solution(int a, int b) {
        int answer = 0;
		
		boolean oddA = a%2!=0;
		boolean oddB = b%2!=0;
		
		if(oddA == true && oddB == true	) {
			answer = a*a + b*b;
		} else if ((oddA == true && oddB == false) || (oddA == false && oddB == true)) {
			answer = 2 * (a + b);
		} else {
			answer = Math.abs(a - b);
		}
		
		return answer;
    }
}