package M04_3;

import java.io.*;
import java.util.*;

public class B6593 {
	static int[] dh = {0,0,0,0,1,-1}; // 오왼앞뒤위아래
	static int[] dr = {0,0,1,-1,0,0}; // 오왼앞뒤위아래
	static int[] dc = {1,-1,0,0,0,0}; // 오왼앞뒤위아래
	
	static int L, R, C;
	static char[][][] map;
	static boolean[][][] v;
	static int endH, endR, endC;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		while(true) {
			st = new StringTokenizer(br.readLine(), " ");
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			if(L==0) break;
			
			int startH = 0, startR = 0, startC = 0;
			map = new char[L][R][C];
			for(int h=0; h<L; h++) {
				for(int r=0; r<R; r++) {
					String str = br.readLine();
					for(int c=0; c<C; c++) {
						map[h][r][c] = str.charAt(c);
						if(map[h][r][c]=='S') {
							startH = h;
							startR = r;
							startC = c;
						}
						else if(map[h][r][c]=='E') {
							endH = h;
							endR = r;
							endC = c;
						}
					}
				}
				br.readLine(); // 빈 줄 읽기
			}
			int min = bfs(startH, startR, startC);
			if(min==-1) sb.append("Trapped!"+"\n");
			else sb.append("Escaped in "+min+" minute(s)."+"\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	static int bfs(int h, int r, int c) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		v = new boolean[L][R][C];
		v[h][r][c] = true;
		q.offer(new int[] {h,r,c,0});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			if(cur[0]==endH && cur[1]==endR && cur[2]==endC) return cur[3];
			
			for(int d=0; d<6; d++) {
				int nh = cur[0] + dh[d];
				int nr = cur[1] + dr[d];
				int nc = cur[2] + dc[d];
				
				if(nh<0 || L<=nh || nr<0 || R<=nr || nc<0 || C<=nc) continue;
				if(v[nh][nr][nc] || map[nh][nr][nc] == '#') continue;
				
				v[nh][nr][nc] = true;
				q.offer(new int[] {nh, nr, nc, cur[3]+1});
			}
		}
		return -1;
	}
}