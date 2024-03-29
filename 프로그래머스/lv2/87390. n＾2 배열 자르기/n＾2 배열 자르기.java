import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left+1)];
        
        long index = left;
        for(int i=0; i<answer.length; i++) {
            int r = (int)((index+i)/n+1);
            int c = (int)((index+i)%n+1);
            
            answer[i] = Math.max(r, c);
        }
        
        return answer;
    }
}