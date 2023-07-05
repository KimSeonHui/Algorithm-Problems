import java.io.*;
import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int index1 = 0; int index2 = 0;
        String answer = "Yes";
        boolean isPossible = true;
        for(int i=0; i<goal.length; i++) {
            if(cards1[index1].equals(goal[i])) {
                if(index1 < cards1.length-1) index1++;
                continue;
            }
            if(cards2[index2].equals(goal[i])) {
                if(index2 < cards2.length-1) index2++;
                continue;
            }
            
            isPossible = false;
            break;
        }
        
        if(!isPossible) answer = "No";
        return answer;
    }
}