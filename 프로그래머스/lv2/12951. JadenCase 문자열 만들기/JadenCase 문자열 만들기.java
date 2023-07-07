import java.io.*;
import java.util.*;

class Solution {
    public String solution(String s) {
        String[] split = s.toLowerCase().split("");
        // System.out.println(Arrays.toString(split));
        
        split[0] = split[0].toUpperCase();
        for(int i=1; i<split.length; i++) {
            if(split[i-1].equals(" ")) split[i] = split[i].toUpperCase();
        }
        
        String answer = "";
        for(int i=0; i<split.length; i++) {
            answer += split[i];
        }
        return answer;
    }
}