import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i=n+1; i<=1000000; i++) {
            if(getCount(Integer.toString(n,2)) == getCount(Integer.toString(i,2))) {
                answer = i;
                break;
            }
        }
        return answer;
    }
    
    public int getCount(String num) {
        int count = 0;
        for(int i=0; i<num.length(); i++) {
            if(num.charAt(i) == '1') count++;
        }
        return count;
    }
}