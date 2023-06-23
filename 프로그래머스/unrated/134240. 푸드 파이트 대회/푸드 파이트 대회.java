import java.io.*;
import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        for(int i=1; i<food.length; i++) {
            if(food[i] / 2 >= 1) {
                for(int j=0; j<food[i] / 2; j++) {
                    answer += i;
                }
            }
        }
        answer += "0";
        String temp = answer;
        for(int i=temp.length()-2; i>=0; i--) {
            answer += temp.charAt(i);
        }
        
        return answer;
    }
}