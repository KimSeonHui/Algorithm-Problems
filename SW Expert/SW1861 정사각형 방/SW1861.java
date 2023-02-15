import java.io.*;
import java.util.*;

public class SW1861 {
	static int[] dr = {-1,0,1,0}; // 상우하좌
    static int[] dc = {0,1,0,-1}; // 상우하좌
    static int N;
    static int[] res;
    static int[][] room;
    static ArrayDeque<int[]> q;
     
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
 
            for(int tc=1; tc<=T; tc++) {
            N = Integer.parseInt(br.readLine());
            room = new int[N][N];
            res = new int[2];
             
            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<N; j++) {
                    room[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    bfs(i,j);
                	//dfs(i,j, new boolean[N][N], 1, new int[]{i,j});
                }
            }
            sb.append("#").append(tc).append(" ").append(res[0]).append(" ").append(res[1]).append("\n");
        }
        System.out.println(sb.toString());
    }
     
    static void bfs(int i, int j) {
        boolean[][] v = new boolean[N][N];
        q= new ArrayDeque<>();
        v[i][j] = true;
        q.offer(new int[] {i,j});
         
        int cnt = 1;
        while(!q.isEmpty()) {
            int[] pos = q.poll();
             
            for(int d=0; d<4; d++) {
                int ni = pos[0] + dr[d];
                int nj = pos[1] + dc[d];
                 
                if(0<=ni&&ni<N && 0<=nj&&nj<N && !v[ni][nj] && room[pos[0]][pos[1]]+1 == room[ni][nj]) {
                    v[ni][nj] = true;
                    q.offer(new int[] {ni, nj});
                    cnt++;
                }
            }
        }
        if(res[1] < cnt) {
            res[0] = room[i][j];
            res[1] = cnt;
        }
        else if(res[1] == cnt) res[0] = Math.min(res[0], room[i][j]);
    }
    
    static void dfs(int i, int j, boolean[][] v, int cnt, int[] start) {
        v[i][j] = true;
         
        if(res[1] < cnt) {
            res[0] = room[start[0]][start[1]];
            res[1] = cnt;
        }
        else if(res[1] == cnt) res[0] = Math.min(res[0], room[start[0]][start[1]]);
         
        for(int d=0; d<4; d++) {
            int ni = i + dr[d];
            int nj = j + dc[d];
                 
            if(0<=ni&&ni<N && 0<=nj&&nj<N && !v[ni][nj] && room[i][j]+1 == room[ni][nj]) {
                v[ni][nj] = true;
                dfs(ni, nj, v, cnt+1, start);
            }
        }
    }

}
