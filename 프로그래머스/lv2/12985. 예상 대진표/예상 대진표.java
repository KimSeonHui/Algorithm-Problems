import java.io.*;
import java.util.*;

class Solution
{
    public int solution(int n, int a, int b)
    {
        // 0-base index로 전환
        a -= 1;
        b -= 1;
        
        int round = 1;
        while(a/2 != b/2) {
            a /= 2;
            b /= 2;
            round++;
        }
        return round;
    }
}