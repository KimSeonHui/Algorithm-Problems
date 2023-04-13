package M04_3;

import java.io.*;
import java.util.*;

public class B17141 {
    static int[] dr = {-1,0,1,0}; // 상우하좌
    static int[] dc = {0,1,0,-1}; // 상우하좌
    
    static int N, M, min;
    static int[][] map, temp;
    static boolean[][] v;
    static List<int[]> birus;
    static int[] res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][N];
        birus = new ArrayList<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2) {
                    birus.add(new int[] {i, j});
                }
            }
        }
        
        res = new int[M];
        min = Integer.MAX_VALUE;
        comb(0, 0);
        System.out.println(min==Integer.MAX_VALUE ? -1 : min);
        br.close();
    }
    
    static void comb(int cnt, int start) {
        if(cnt == M) {
            // 임시 테이블 초기화
            temp = new int[N][N];
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) temp[i][j] = map[i][j];
            }
            
            // 선택한 위치에 바이러스 두기
            ArrayDeque<int[]> q = new ArrayDeque<>();
            for(int i=0; i<M; i++) {
                int r = birus.get(res[i])[0];
                int c = birus.get(res[i])[1];
                q.offer(new int[] {r, c, 0});
                temp[r][c] = -1;
            }
            

            int time = spreadBirus(q);
            if(isAllSpread()) min = Math.min(min, time);
            return;
        }
        for(int i=start; i<birus.size(); i++) {
            res[cnt] = i;
            comb(cnt+1, i+1);
        }
    }
    
    static boolean isAllSpread() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(temp[i][j] == 0) return false;
            }
        }
        return true;
    }
    
    static int spreadBirus(ArrayDeque<int[]> q) {
        int time = 0;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            time = cur[2];
            
            for(int d=0; d<4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                
                if(0<=nr&&nr<N && 0<=nc&&nc<N && (temp[nr][nc]!=1 && temp[nr][nc]!=-1)) {
                    temp[nr][nc] = -1;
                    q.offer(new int[] {nr,nc,cur[2]+1});
                }
            }
        }
        return time;
    }

}
