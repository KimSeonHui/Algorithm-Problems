import java.io.*;
import java.util.*;

class Solution {
    int[] dr = {-1, 0, 1, 0}; // 상우하좌
    int[] dc = {0, 1, 0, -1}; // 상우하좌
    boolean[][] v;
    int n, m;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        v = new boolean[n][m];
        
        return bfs(0, 0, maps);
    }
    
    public int bfs(int r, int c, int[][] maps) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        v[r][c] = true;
        q.offer(new int[]{r, c, 1});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curR = cur[0];
            int curC = cur[1];
            int depth = cur[2];
            
            if(curR == (n-1) && curC == (m-1)) return depth;
            
            for(int d=0; d<4; d++) {
                int nr = curR + dr[d];
                int nc = curC + dc[d];
                
                // 맵 범위 안에 있고, 방문하지 않았고, 벽이 없는 자리이면
                if(0<=nr&&nr<n && 0<=nc&&nc<m && !v[nr][nc] && maps[nr][nc] == 1) {
                    v[nr][nc] = true;
                    q.offer(new int[]{nr, nc, depth+1});
                }
            }
        }
        return -1;
    }
}