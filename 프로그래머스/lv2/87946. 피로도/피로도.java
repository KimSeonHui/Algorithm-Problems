import java.io.*;
import java.util.*;

class Solution {
    int[] order;
    boolean[] visited;
    int max;
    
    public int solution(int k, int[][] dungeons) {
        order = new int[dungeons.length];
        visited = new boolean[dungeons.length];
        max = 0;
        
        perm(0, k, dungeons);
        return max;
    }
    
    public void perm(int cnt, int k, int[][] dungeons) {
        if(cnt == dungeons.length) {
            // 던전 방문 순서 결정 완료
            // System.out.println(Arrays.toString(order));

            
            int dungeonCnt = 0; // 방문한 던전 수
            for(int i=0; i<order.length; i++) {
                if(k >= dungeons[order[i]][0]) { // 현재 피로도가 방문할 던전의 최소 필요도 이상이면
                    dungeonCnt++;
                    k -= dungeons[order[i]][1];
                }
            }
            
            max = Math.max(max, dungeonCnt);
            return;
        }
        
        for(int i=0; i<dungeons.length; i++) {
            if(visited[i]) continue;
            
            visited[i] = true;
            order[cnt] = i;
            perm(cnt+1, k, dungeons);
            visited[i] = false;
        }
    }
}