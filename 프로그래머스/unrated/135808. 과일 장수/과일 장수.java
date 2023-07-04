import java.io.*;
import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        // System.out.println(Arrays.toString(score));
        
        int answer = 0;
        for(int i=score.length; i>=m; i-=m) {
            answer += score[i-m] * m;
        }
        
        return answer;
    }
}