import java.io.*;
import java.util.*;

class Solution {
    int index = 0;
    boolean isFind = false;
    char[] alpha = {'A' , 'E', 'I', 'O', 'U'};
    
    public int solution(String word) {
        perm(0, "", word);
        return index-1;
    }
    
    public void perm(int cnt, String str, String word) {
        if(isFind || 5 < str.length()) return;
         index++;
        if(str.equals(word))  isFind = true;
        
        for(int i=0; i<alpha.length; i++) {
            perm(cnt+1, str+alpha[i], word);
        }
    }
}