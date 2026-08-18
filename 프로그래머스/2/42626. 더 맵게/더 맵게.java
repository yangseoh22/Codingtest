import java.io.*;
import java.util.*;

class Solution {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int solution(int[] scoville, int K) {
        int cnt = 0;
        
        for(int i=0; i<scoville.length; i++){
            pq.add(scoville[i]);
        }
        
        while(pq.size()>1){
            if(upperK(K)){
                return cnt;
            } else{
                pq.add(pq.poll() + pq.poll()*2);
                cnt++;
            }
        }
        if(pq.peek()>= K) return cnt;
        else return -1;
    }
    
    public boolean upperK(int N){
        for(int i=0; i<pq.size(); i++){
            int num = pq.poll();
            if(num < N){
                pq.add(num);
                return false;
            }
        }
        return true;
    }
}