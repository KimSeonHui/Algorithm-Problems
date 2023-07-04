import java.io.*;
import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        // System.out.println(Arrays.toString(score));
        
        int answer = 0;
        for(int i=score.length-1; i-m>=-1; i-=m) {
            int sum = 0; int count = 0;
            int end = i-m;
            for(int j=i; j>end; j--) {
                sum += score[j];
                count++;
            }
            
            int min = score[end+1];
            // System.out.println("min " + min);
            if(count == m) {
                answer += min * m;
            }
        }
        
        return answer;
    }
}