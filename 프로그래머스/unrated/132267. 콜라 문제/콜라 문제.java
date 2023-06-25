import java.io.*;
import java.util.*;

class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while(n >= a) {
            int restBottle = n % a;
            int getBottle = n / a * b;
            answer += getBottle;
            n = getBottle + restBottle;
        }
        
        return answer;
    }
}