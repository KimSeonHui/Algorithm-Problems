import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        
        int start = 0; int end = 0; int cnt = 0; int sum = 0;
        while(start < elements.length) {
            sum += elements[end];
            set.add(sum);
            end++;
            cnt++;
            
            if(end >= elements.length) {
                end = 0;
            }
            if(cnt == elements.length) {
                cnt = 0;
                sum = 0;
                start++;
                end = start;
            }
        }
        
        // System.out.println(set);
        return set.size();
    }
}