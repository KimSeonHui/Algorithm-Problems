import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        int[] alpha = new int[26];
        for(int i=0; i<26; i++) alpha[i] = -1;
        
        int[] answer = new int[s.length()];
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(alpha[ch-'a'] == -1) answer[i] = -1;
            else answer[i] = i - alpha[ch-'a'];
            alpha[ch-'a'] = i;
        }
        return answer;
    }
}