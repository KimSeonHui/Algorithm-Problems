import java.io.*;
import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        // 초기화
        int[][] g = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(i==j) g[i][j] = 0;
                else g[i][j] = Integer.MAX_VALUE/2;
            }
        }

        // 그래프 만들기
        for(int i=0; i<road.length; i++) {
            int from = road[i][0];
            int to = road[i][1];
            int weight = road[i][2];

            g[from][to] = Math.min(g[from][to], weight);
            g[to][from] = g[from][to];
        }

        // 플로이드워샬 - 출발지가 고정(1번)
        for(int k=1; k<=N; k++){ // 경유지
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) { // 도착지
                    g[i][j] = Math.min(g[i][j], g[i][k]+g[k][j]);
                }
            }
        }

        for(int i=1; i<=N; i++) {
            if(g[1][i] <= K) answer++;
        }

        return answer;
    }
}