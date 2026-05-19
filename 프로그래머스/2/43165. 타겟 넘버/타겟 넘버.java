class Solution {
    static int tarCnt;
   	public static int solution(int[] numbers, int target) {
		tarCnt = 0;
		dfs(numbers, 0, 0, target);
		return tarCnt;
	}
	
	public static void dfs(int[] arr, int idx, int now, int target) {
		
		// 모든 숫자를 썼다면 결과 반환
		if(idx == arr.length) {
			if(now == target) {
				tarCnt++;
			}
			return;
		}

		dfs(arr, idx+1, now + arr[idx], target);

		dfs(arr, idx+1, now - arr[idx], target);
		
	}
}