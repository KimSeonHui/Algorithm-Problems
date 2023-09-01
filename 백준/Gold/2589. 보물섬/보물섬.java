import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {-1, 0, 1, 0}; // 상우하좌
    static int[] dc = {0, 1, 0, -1}; // 상우하좌
    static char[][] map;
    static boolean[][] v;
    static int R, C, max = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 받기
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        v = new boolean[R][C];

        // 지도 입력 받기
        for(int r=0; r<R; r++) {
            String str = br.readLine();
            for(int c=0; c<C; c++) {
                map[r][c] = str.charAt(c);
            }
        }

        // L-> L까지 가는 거리 중 가장 먼 거리 찾기 -> 보물이 있는 곳을 최단 거리로 이동하는 방법
        for(int r=0; r<R; r++) {
            for(int c=0; c<C; c++) {
                if(map[r][c] == 'L') {
                    init(); // 방문 배열 초기화
                    bfs(r, c);
                }
            }
        }

        System.out.println(max);
    }

    // 방문 배열 초기화
    static void init() {
        for(int r=0; r<R; r++) {
            for(int c=0; c<C; c++) {
                v[r][c] = false;
            }
        }
    }

    static void bfs(int r, int c) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        v[r][c] = true;
        q.offer(new int[]{r, c, 0}); // r, c, depth

        int size = 0;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            size = cur[2];

            for(int d=0; d<4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                // 범위 안에 있고 방문하지 않았고 육지이면
                if(0<=nr&&nr<R && 0<=nc&&nc<C && !v[nr][nc] && map[nr][nc] == 'L') {
                    v[nr][nc] = true;
                    q.offer(new int[]{nr, nc, cur[2]+1});
                }
            }
        }
        max = Math.max(max, size);
    }
}