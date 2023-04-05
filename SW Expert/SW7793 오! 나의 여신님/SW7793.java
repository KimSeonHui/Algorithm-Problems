package M04_1;

import java.io.*;
import java.util.*;

public class SW7793 {
	static int[] dr = {-1,0,1,0}; // 상우하좌
	static int[] dc = {0,1,0,-1}; // 상우하좌
	
	static int N, M, min;
	static int[][] time;
	static char[][] map;
	static boolean[][] v;
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new char[N][M];
			time = new int[N][M];
			ArrayDeque<int[]> devils = new ArrayDeque<>();
			int r=0, c=0; // 수연이 위치
            
			for(int i=0; i<N; i++) {
				String str = br.readLine();
				for(int j=0; j<M; j++) {
					map[i][j] = str.charAt(j);
					time[i][j] = Integer.MAX_VALUE;
					if(map[i][j]=='S') {
						map[i][j]='.';
						r = i;
						c = j;
					}
					else if(map[i][j]=='*') {
						time[i][j] = 0;
						devils.offer(new int[] {i,j, 0});
					}
				}
			}
			
			// 악마 스킬 확산
			devilBfs(devils);
			
			//수연 bfs
			min = Integer.MAX_VALUE;
			v = new boolean[N][M];
			bfs(r,c);
			sb.append("#").append(t).append(" ").append((min==Integer.MAX_VALUE?"GAME OVER":min)).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	static void devilBfs(ArrayDeque<int[]> q) {
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int d=0; d<4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(0<=nr&&nr<N && 0<=nc&&nc<M && map[nr][nc]=='.') {
					map[nr][nc] = '*';
					time[nr][nc] = cur[2]+1;
					q.offer(new int[] {nr,nc,cur[2]+1});
				}
			}
		}
	}
	
	static void bfs(int r, int c) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		v[r][c] = true;
		q.offer(new int[] {r, c, 0});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			if(map[cur[0]][cur[1]]=='D') {
				min = Math.min(min, cur[2]);
				return;
			}
			
			for(int d=0; d<4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(0<=nr&&nr<N && 0<=nc&&nc<M && !v[nr][nc] && map[nr][nc]!='X') {
					if(cur[2]+1<time[nr][nc] || map[nr][nc]=='D') {
						v[nr][nc] = true;
						q.offer(new int[] {nr,nc,cur[2]+1});
					}
				}
			}
		}
	}
}