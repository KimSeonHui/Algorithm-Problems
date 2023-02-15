import java.io.*;
import java.util.*;

public class SW1277 {
	static int[] dr = {-1,0,1,0}; // 상우하좌
    static int[] dc = {0,1,0,-1}; // 상우하좌
    static boolean[][] v;
    static int[][] maze;
    static StringBuilder sb;
    static int ans = 0;
     
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
 
        for(int tc=1; tc<=10; tc++) {
            int tcNum = Integer.parseInt(br.readLine());
            maze = new int[100][100];
            v = new boolean[100][100];
            ans = 0;
             
            for(int i=0; i<100; i++) {
                String str = br.readLine();
                for(int j=0; j<100; j++) {
                    maze[i][j] = str.charAt(j)-'0';
                }
            }
             
            sb.append("#").append(tc).append(" ");
            dfs(1,1);
            sb.append(ans).append("\n");
        }
        System.out.println(sb.toString());
    }
     
    static void dfs(int i, int j) {
        if(maze[i][j] == 3) {
            ans = 1;
            return;
        }
         
        v[i][j] = true;
        for(int d=0; d<4; d++) {
            int ni = i + dr[d];
            int nj = j + dc[d];
             
            if(0<=ni&&ni<100 && 0<=nj&&nj<100 && !v[ni][nj] && (maze[ni][nj]==0||maze[ni][nj]==3)) {
                dfs(ni,nj);
            }
        }
    }
}
