import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        int yellowH = 1;
        while(true) {
            if(yellow % yellowH == 0) {
                int yellowW = yellow / yellowH;    
                //System.out.println(yellowW);

                int width = yellowW + 2;
                int height = yellowH + 2;

                if(width*height == yellow + brown) {
                    answer = new int[]{width, height};
                    break;
                }
            }
            yellowH++;
        }
        return answer;
    }
}
