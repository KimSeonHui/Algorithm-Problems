package M04_1;

import java.io.*;
import java.util.*;

public class B4179 {
	static int[] dr = {-1,0,1,0}; // 상우하좌
	static int[] dc = {0,1,0,-1}; // 상우하좌
	static int R, C, min;
	static char[][] map;
	static int[][] time;
	static boolean[][] v;
	static ArrayDeque<int[]> fireQ;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		int r=0, c = 0;
		map = new char[R][C];
		time = new int[R][C];
		fireQ = new ArrayDeque<>();
		v = new boolean[R][C];
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j]=='J') {
					r = i;
					c = j;
				}
				if(map[i][j]=='F') {
					fireQ.offer(new int[] {i,j,1});
					time[i][j] =1;
					v[i][j] = true;
				}
			}
		}
		
		min = Integer.MAX_VALUE;
		fireBfs(fireQ);
		bfs(r, c);
		
		System.out.println((min==0? "IMPOSSIBLE" : min));
		br.close();
	}
	
	static void bfs(int r, int c) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		v = new boolean[R][C];
		v[r][c] = true;
		q.offer(new int[] {r, c, 1});
		
		int depth = 0;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			if(0<time[cur[0]][cur[1]] && time[cur[0]][cur[1]] <= cur[2]) continue;
			if(cur[0]==0 || cur[0]==R-1 || cur[1]==0 || cur[1]==C-1) {
				depth = cur[2];
				break;
			}
			
			for(int d=0; d<4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(0<=nr&&nr<R && 0<=nc&&nc<C && !v[nr][nc] && (map[nr][nc]!='#' && map[nr][nc]!='F')) {
					v[nr][nc] = true;
					q.offer(new int[] {nr,nc,cur[2]+1});
				}
			}
			
		}
		min = Math.min(min, depth);
	}
	
	static void fireBfs(ArrayDeque<int[]> fireQ) {
		while(!fireQ.isEmpty()) {
			int[] fire = fireQ.poll();
			
			for(int d=0; d<4; d++) {
				int fr = fire[0] + dr[d];
				int fc = fire[1] + dc[d];
				
				if(0<=fr&&fr<R && 0<=fc&&fc<C && !v[fr][fc] && (map[fr][fc]!='#' && map[fr][fc]!='F')) {
					time[fr][fc] = fire[2]+1;
					v[fr][fc] = true;
					fireQ.offer(new int[] {fr,fc, fire[2]+1});
				}
			}
		}
	}
}
