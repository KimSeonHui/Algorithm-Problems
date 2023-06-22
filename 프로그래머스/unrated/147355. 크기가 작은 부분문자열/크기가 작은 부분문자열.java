import java.io.*;
import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        for(int i=0; i+p.length()<=t.length(); i++) {
            String temp = t.substring(i, i+p.length());
            if(Long.parseLong(temp) <= Long.parseLong(p)) answer++;
        }
        return answer;
    }
}