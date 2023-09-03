import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {-1, 0, 1, 0}; // 상우하좌
    static int[] dc = {0, 1, 0, -1}; // 상우하좌
    static char[][] map;
    static boolean[][] v;

    static int R, C, whiteTeam, blueTeam;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for(int r=0; r<R; r++) {
            String str = br.readLine();
            for(int c=0; c<C; c++) {
                map[r][c] = str.charAt(c);
            }
        }

        // Team 위력 계산
        v = new boolean[R][C];
        for(int r=0; r<R; r++) {
            for(int c=0; c<C; c++) {
                if(!v[r][c]) {
                    bfs(r,c, map[r][c]);
                }
            }
        }
        System.out.println(whiteTeam + " " + blueTeam);
    }

    static void bfs(int r, int c, char team) {
        int cnt = 0;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        v[r][c] = true;
        q.offer(new int[]{r, c});
        cnt++;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int d=0; d<4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                // 범위 안에 있고 방문하지 않았고 같은 team이면
                if(0<=nr&&nr<R && 0<=nc&&nc<C && !v[nr][nc] && map[nr][nc] == team) {
                    v[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                    cnt++;
                }
            }
        }

        if(team == 'W') whiteTeam += cnt * cnt;
        else blueTeam += cnt * cnt;
    }
}