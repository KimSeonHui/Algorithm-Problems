import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        int y = 1;
        while(y <= yellow) {
            if(yellow % y == 0) {
                int yellowH = Math.min(y, yellow / y);    
                int yellowW = Math.max(y, yellow / y);    
                //System.out.println(yellowW);

                int width = yellowW + 2;
                int height = yellowH + 2;

                if(width*height == yellow + brown) {
                    answer = new int[]{width, height};
                    break;
                }
            }
            y++;
        }
        return answer;
    }
}