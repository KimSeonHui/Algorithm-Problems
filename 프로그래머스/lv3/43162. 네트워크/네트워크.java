import java.io.*;
import java.util.*;

class Solution {
    static boolean[][] v;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        v = new boolean[n][n];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(!v[i][j] && computers[i][j] == 1) {
                    bfs(i, j, computers);
                    answer++;
                }
            }
        }
        return answer;
    }
    
    public void bfs(int r, int c, int[][] computers) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        v[r][c] = true;
        q.offer(new int[]{r,c});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int from = cur[0];
            int to = cur[1];
            
           // System.out.println("from " + from + " to "  + to);
            
            for(int i=0; i<computers.length; i++) {
                if(!v[to][i] && computers[to][i] == 1) {
                    v[to][i] = true;
                    q.offer(new int[]{to, i});
                }
            }
        }
    }
}