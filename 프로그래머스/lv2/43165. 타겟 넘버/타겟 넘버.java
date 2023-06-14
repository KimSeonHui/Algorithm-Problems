import java.io.*;
import java.util.*;

class Solution {
    static int[] input = {0 , 1}; // 0 : +, 1 : -
    static int N, ans;
    
    public int solution(int[] numbers, int target) {
        ans = 0;
        N = numbers.length;
        
        makeTargetNum(0, 0, numbers, target);    
        
        return ans;
    }
    
    public void makeTargetNum(int cnt, int made, int[] numbers, int target) {
        if(cnt == N) {
            if(made == target) ans++;
            return;
        }
        
        for(int i=0; i<input.length; i++) {
            if(input[i] == 0) makeTargetNum(cnt+1, made+numbers[cnt], numbers, target);
            else makeTargetNum(cnt+1, made-numbers[cnt], numbers, target);
        }
    }
}