import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1, o2));
        pq.offer(score[0]);
        int min = score[0];
        answer[0] = min;
        for(int i=1; i<score.length; i++) {
            pq.offer(score[i]);
            if(pq.size() > k) {
                pq.poll();
            }
            min = pq.peek();
            answer[i] = min;
        }
        return answer;
    }
}