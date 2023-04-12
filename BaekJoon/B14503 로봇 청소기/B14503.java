package M04_3;

import java.io.*;
import java.util.*;

public class B14503 {
	static class Robot {
		int r, c, dir, clean;
		
		public Robot(int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}
	static int[] dr = {-1,0,1,0}; // 상우하좌
	static int[] dc = {0,1,0,-1}; // 상우하좌
	static int N, M;
	static int[][] room;
	static Robot robot;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		robot = new Robot(r, c, dir);
		
		room = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(clean());
		br.close();
	}
	
	static int clean() {
		next : while(true) {
			int r = robot.r;
			int c = robot.c;
			int dir = robot.dir;
			
			// step1
			if(room[r][c]==0) {
				robot.clean++;
				room[r][c] = -1;
			}
			
			
			for(int d=0; d<4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				
				// 범위 안에 있고, 청소 되지 않은 빈 칸이면
				if(0<=nr&&nr<N && 0<=nc&&nc<M && room[nr][nc]==0) {
					// step3
					if(dir==0) robot.dir = 3;
					else robot.dir = dir-1;
					
					int tr = r+dr[robot.dir];
					int tc = c+dc[robot.dir];
					if(0<=tr&&tr<N && 0<=tc&&tc<M) {
						if(room[tr][tc]==0) {
							robot.r = tr;
							robot.c = tc;
						}
						continue next;
					}
				}
			}
			
			// step2
			int oppDir = (dir+2)%4;
			int tr = r+dr[oppDir];
			int tc = c+dc[oppDir];
			if(0<=tr&&tr<N && 0<=tc&&tc<M) {
				if(room[tr][tc] != 1) {
					robot.r = tr;
					robot.c = tc;
				}
				else if(room[tr][tc] == 1) break;
			}
		}
		
		return robot.clean;
	}
}