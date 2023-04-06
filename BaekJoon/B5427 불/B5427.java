package M04_1;

import java.io.*;
import java.util.*;

public class B5427 {
	static int[] dr = {-1,0,1,0}; //상우하좌
	static int[] dc = {0,1,0,-1}; //상우하좌
	
	static char[][] map;
	static int[][] time;
	static boolean[][] v;
	static int R, C;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			
			map = new char[R][C];
			time = new int[R][C];
			ArrayDeque<int[]> fires = new ArrayDeque<>();
			int r=0, c=0;
			for(int i=0; i<R; i++) {
				char[] ch = br.readLine().toCharArray();
				for(int j=0; j<C; j++) {
					time[i][j] = Integer.MAX_VALUE;
					map[i][j] = ch[j];
					if(map[i][j]=='*') {
						fires.offer(new int[] {i,j,1});
						time[i][j] = 1;
					}
					else if(map[i][j]=='@') {
						map[i][j] = '.';
						r=i;
						c=j;
					}
				}
			}
			
			fireBfs(fires);
			v = new boolean[R][C];
			int ans = sBfs(r, c);
			sb.append(ans==0? "IMPOSSIBLE" : ans).append("\n") ;
		}
		System.out.println(sb);
		br.close();
	}
	
	static void fireBfs(ArrayDeque<int[]> q) {
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int d=0; d<4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(0<=nr&&nr<R && 0<=nc&&nc<C && map[nr][nc]=='.') {
					time[nr][nc] = cur[2]+1;
					map[nr][nc] = '*';
					q.offer(new int[] {nr, nc, cur[2]+1});
				}
			}
		}
	}
	
	static int sBfs(int r, int c) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		v[r][c] = true;
		q.offer(new int[] {r, c, 1});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			if(cur[0]==0 || cur[0]==R-1 || cur[1]==0 || cur[1]==C-1) return cur[2];
			
			for(int d=0; d<4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(0<=nr&&nr<R && 0<=nc&&nc<C && !v[nr][nc] && map[nr][nc]!='#') {
					if(cur[2]+1 < time[nr][nc]) {
						v[nr][nc] = true;
						q.offer(new int[] {nr, nc, cur[2]+1});
					}
				}
			}
		}
		return 0;
	}
}