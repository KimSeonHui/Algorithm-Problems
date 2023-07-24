import java.io.*;
import java.util.*;

class Solution {
    public long solution(int n) {
        long[] dp;
        if(n == 1) return 1;
        else if(n == 2) return 2;
        else {
            dp = new long[n+1]; // i번째 칸에 도달하는 방법의 수
            dp[1] = 1;
            dp[2] = 2;
            
            for(int i=3; i<=n; i++) {
                // i번째 칸에 도달하는 방법의 수 
                // = 마지막에 2칸을 뛰었을 때의 경우의 수 >> i-2번째 칸에서 i칸까지 2칸을 뜀 >> i-2칸까지 도달하는 경우의 수(dp[i-2]) 
                // + 마지막에 1칸을 뛰었을 때의 경우의 수 >> i-1번째 칸에서 i칸까지 1칸을 뜀 >> -1칸까지 도달하는 경우의 수(dp[i-1])
                dp[i] = dp[i-2]%1234567 + dp[i-1]%1234567;
            }
        }
        
        return dp[n]%1234567;
    }
}