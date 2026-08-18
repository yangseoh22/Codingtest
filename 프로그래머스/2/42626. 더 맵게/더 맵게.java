import java.io.*;
import java.util.*;

class Solution {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int solution(int[] scoville, int K) {
        int cnt = 0;
        
        for(int i=0; i<scoville.length; i++){
            pq.add(scoville[i]);
        }
        
        // 큐에 남은 요소가 1개 초과면서, 가장 작은 수가 K미만이면 반복
        while(pq.size() > 1 && pq.peek() < K){
            pq.add(pq.poll() + pq.poll()*2);
            cnt++;
        }
        
        // 남은 하나의 수가 K이상이면 횟수, 아니면 -1 반환
        if(pq.peek()>= K) return cnt;
        else return -1;
    }
}