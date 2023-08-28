import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1, o2));
        for(int i=0; i<scoville.length; i++) {
            pq.offer(scoville[i]);
        }
        
        int cnt = 0;
        while(true) {
            int min = pq.poll();
            
            if(min >= K) break;
            if(pq.isEmpty()) return -1;
            
            int mixedScoville = min + (pq.poll() * 2);
            cnt++;
            pq.offer(mixedScoville);
        }
        
        return cnt;
    }
}