package M04_4;

import java.io.*;
import java.util.*;

public class B1600 {
	static int[] dr = {-1,0,1,0}; // 상우하좌
	static int[] dc = {0,1,0,-1}; // 상우하좌
	static int[] hr = {-1,-2,-2,-1,1,2,2,1} ;// 10, 11, 1,2, 4,5, 7,8
	static int[] hc = {-2,-1,1,2,2,1,-1,-2} ;// 10, 11, 1,2, 4,5, 7,8
	
	static int R, C, K;
	static int[][] map;
	static boolean[][][] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(bfs(0,0));
		br.close();
	}
	
	static int bfs(int r, int c) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		v = new boolean[R][C][K+1];
		v[r][c][0]=  true;
		q.offer(new int[] {r, c, 0, 0}); // r, c, 말처럼 이동한 횟수, depth
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cnt = cur[2];
			int depth = cur[3];
			
			if(cur[0]==R-1 && cur[1]==C-1) return depth;
			
			for(int d=0; d<4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				// 범위 안이고 방문하지 않았고 평지이면
				if(0<=nr&&nr<R && 0<=nc&&nc<C && !v[nr][nc][cnt] && map[nr][nc]==0) {
					v[nr][nc][cnt] = true;
					q.offer(new int[] {nr, nc, cnt, depth+1});
				}
			}
			
			if(cnt>=K) continue;
			for(int d=0; d<8; d++) {
				int nr = cur[0] + hr[d];
				int nc = cur[1] + hc[d];
				
				// 범위 안이고 방문하지 않았고 평지이면
				if(0<=nr&&nr<R && 0<=nc&&nc<C && !v[nr][nc][cnt+1] && map[nr][nc]==0) {
					v[nr][nc][cnt+1] = true;
					q.offer(new int[] {nr, nc, cnt+1, depth+1});
				}
			}
		}
		return -1;
	}
}
