import java.io.*;
import java.util.*;

class Solution {
    int answer = 0;
    int[] res = new int[3];
    
    public int solution(int[] number) {
        comb(0, 0, 0, number);
        return answer;
    }
    
    public void comb(int cnt, int start, int sum, int[] number) {
        if(cnt == 3) {
            //System.out.println(Arrays.toString(res));
            if(sum == 0) answer++;
            return;
        }
        
        for(int i=start; i<number.length; i++) {
            res[cnt] = number[i];
            comb(cnt+1, i+1, sum+number[i], number);
        }
    }
}