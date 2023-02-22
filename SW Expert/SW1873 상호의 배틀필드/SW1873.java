package M02_4;

import java.io.*;
import java.util.*;

class Tank {
	int r;
	int c;
	char dir;
	
	public Tank(int r, int c, char dir) {
		this.r = r;
		this.c = c;
		this.dir = dir;
	}
}

class Solution
{
    static int R, C, N;
	static char[][] map;
	static char[] inputs;
	static Tank tank;
    
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
			for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[R][C];
			
			for(int i=0; i<R; i++) {
				String str = br.readLine();
				for(int j=0; j<C; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j]=='^') tank = new Tank(i,j,'u');
					else if(map[i][j]=='v') tank = new Tank(i,j,'d');
					else if(map[i][j]=='<') tank = new Tank(i,j,'l');
					else if(map[i][j]=='>') tank = new Tank(i,j,'r');
				}
			}
			
			N = Integer.parseInt(br.readLine());
			String str = br.readLine();
			inputs = str.toCharArray();
			
			for(int i=0; i<N; i++) {
				play(inputs[i]);
			}
			
			// 명령 끝난 후 탱크 위치 저장
			if(tank.dir=='u') map[tank.r][tank.c] = '^';
			else if(tank.dir=='d') map[tank.r][tank.c] = 'v';
			else if(tank.dir=='l') map[tank.r][tank.c] = '<';
			else if(tank.dir=='r') map[tank.r][tank.c] = '>';
			
			sb.append("#").append(t).append(" ");
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
		br.close();
	}
    
    static void play(char order) {
		if(order == 'S') shoot();
		else move(order);
	}
	
	// 전차 이동
	static void move(char order) {
		map[tank.r][tank.c] = '.';
		if(order == 'U') {
			tank.dir = 'u';
			if(0<=tank.r-1 && map[tank.r-1][tank.c]=='.') tank.r-=1;
		}
		else if(order == 'D') {
			tank.dir = 'd';
			if(tank.r+1<R && map[tank.r+1][tank.c]=='.') tank.r+=1;
		}
		else if(order == 'L') {
			tank.dir = 'l';
			if(0<=tank.c-1 && map[tank.r][tank.c-1]=='.') tank.c-=1;
		}
		else {
			tank.dir = 'r';
			if(tank.c+1<C && map[tank.r][tank.c+1]=='.') tank.c +=1;
		}
	}
	
	
	// 벽에 부딪히거나 맵 밖으로 나갈 때까지 직진
	static void shoot() {
		// 위쪽으로 발사
		if(tank.dir == 'u') {
			int bomb=tank.r;
			while(true) {
				if(bomb<0 || map[bomb][tank.c]=='*' || map[bomb][tank.c]=='#') {
					if(0<=bomb && map[bomb][tank.c]=='*') map[bomb][tank.c]='.';
					break;
				}
				bomb--;
			}
		}
		// 아래쪽으로 발사
		else if(tank.dir == 'd') {
			int bomb=tank.r;
			while(true) {
				if(bomb>=R || map[bomb][tank.c]=='*' || map[bomb][tank.c]=='#') {
					if(bomb<R && map[bomb][tank.c]=='*') map[bomb][tank.c]='.';
					break;
				}
				bomb++;
			}
		}
		// 왼쪽으로 발사
		else if(tank.dir == 'l') {
			int bomb=tank.c;
			while(true) {
				if(bomb<0 || map[tank.r][bomb]=='*' || map[tank.r][bomb]=='#') {
					if(0<=bomb && map[tank.r][bomb]=='*') map[tank.r][bomb]='.';
					break;
				}
				bomb--;
			}
		}
		// 오른쪽으로 발사
		else {
			int bomb=tank.c;
			while(true) {
				if(bomb>=C || map[tank.r][bomb]=='*' || map[tank.r][bomb]=='#') {
					if(bomb<C && map[tank.r][bomb]=='*') map[tank.r][bomb]='.';
					break;
				}
				bomb++;
			}
		}
	}
    
}