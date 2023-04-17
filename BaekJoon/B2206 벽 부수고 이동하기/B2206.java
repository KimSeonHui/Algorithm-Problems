package M04_4;

import java.io.*;
import java.util.*;

public class B2206 {
	static int[] dr = {-1,0,1,0}; // 상우하좌
	static int[] dc = {0,1,0,-1}; // 상우하좌
	static int R, C, min;
	static int[][] map;
	static boolean[][][] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		System.out.println(bfs(0, 0));
		br.close();
	}
	
	static int bfs(int r, int c) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		v = new boolean[R][C][2];
		v[r][c][0] = true;
		q.offer(new int[] {r,c,0,1}); //r, c, 벽 부순 횟수, depth
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cnt = cur[2];
			int depth = cur[3];
			
			if(cur[0]==R-1 && cur[1]==C-1) return depth;
			
			for(int d=0; d<4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				//범위 안에 있고, 방문하지 않았고, 이동가능한 곳이면
				if(0<=nr&&nr<R && 0<=nc&&nc<C && !v[nr][nc][cnt] && map[nr][nc]==0) {
					v[nr][nc][cnt] = true;
					q.offer(new int[] {nr, nc, cnt, depth+1});
				}
			}
			

			if(cnt >=1) continue; // 벽을 부수지 못하면
			
			for(int d=0; d<4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				//범위 안에 있고, 방문하지 않았고, 벽이면
				if(0<=nr&&nr<R && 0<=nc&&nc<C && !v[nr][nc][1] && map[nr][nc]==1) {
					v[nr][nc][1] = true;
					q.offer(new int[] {nr, nc, cnt+1, depth+1});
				}
			}
		}
		
		return -1;
	}

}
