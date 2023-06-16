import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        
        int[][] dp = new int[n][triangle[n-1].length];
        dp[0][0] = triangle[0][0];
        
        for(int i=1; i<n; i++) {
            for(int j=0; j+1<=i; j++) {
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j]+triangle[i][j]);
                dp[i][j+1] = Math.max(dp[i][j+1], dp[i-1][j]+triangle[i][j+1]);
            }
        }
        
        // for(int[] a : dp) System.out.println(Arrays.toString(a));
       
        int answer = dp[n-1][0];
        for(int i=1; i<triangle[n-1].length; i++) {
            if(answer < dp[n-1][i]) answer = dp[n-1][i];
        }
        
        return answer;
    }
}