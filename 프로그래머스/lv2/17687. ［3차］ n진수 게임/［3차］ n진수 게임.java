import java.io.*;
import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<=t*m; i++) {
            sb.append(Integer.toString(i,n));
        }
        String nums = sb.toString();
        
        StringBuilder answer = new StringBuilder();
        for(int i=0; i<nums.length(); i++) {
            if(i%m == (p-1)) answer.append(String.valueOf(nums.charAt(i)));
            if(answer.length() == t) break;
        }
        
        return answer.toString().toUpperCase();
    }
}