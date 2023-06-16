import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        // 그래프 초기화
        int[][] g = new int[n+1][n+1];
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(i == j) g[i][j] = 0;
                else g[i][j] = Integer.MAX_VALUE / 2;
            }
        }
        
        // 그래프 연결
        for(int i=0; i<results.length; i++) {
            int to = results[i][0];
            int from = results[i][1];
            
            g[from][to] = 1; // 유향
        }
        
        //플로이드워샬
        for(int k=1; k<=n; k++) {
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
                }
            }
        }
        
       // for(int[] a : g) System.out.println(Arrays.toString(a));
        for(int i=1; i<=n; i++) {
            int cnt = 0;
            for(int j=1; j<=n; j++) {
                if(g[i][j] != 0 && g[i][j] < Integer.MAX_VALUE / 2) cnt++; // 진출
                if(g[j][i] != 0 && g[j][i] < Integer.MAX_VALUE / 2) cnt++; // 진입
            }
            //System.out.println(i + " " + cnt);
            if(cnt == n-1) answer++;
        }
        return answer;
    }
}