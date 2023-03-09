package M03_2;

import java.io.*;
import java.util.*;

class Cell {
	int r, c, life, temp;
	String state;
	
	public Cell(int r, int c, int life, int temp, String state) {
		this.r = r;
		this.c = c;
		this.life = life;
		this.temp = temp;
		this.state = state;
	}

	public void setState() {
		switch(state) {
			case "off" :
				if(++temp==life) state="on";
				break;
			
			case "on" :
				if(--temp==0) state="death";
				break;
		}
	}
}

public class SW5653 {
	static int[] dr = {-1,0,1,0}; // 상우하좌
	static int[] dc = {0,1,0,-1}; // 상우하좌
	
	static int N, M, K;
	static int[][] map;
	static boolean[][] v;
	static ArrayDeque<Cell> q;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/input_sw5653.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N+K][M+K];
			v = new boolean[N+K][M+K];
			q = new ArrayDeque<>();
			for(int i=(N+K)/2-(N/2); i<(N+K)/2-(N/2)+N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=(M+K)/2-(M/2); j<(M+K)/2-(M/2)+M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]!=0) {
						v[i][j] = true;
						q.offer(new Cell(i, j, map[i][j], 0, "off"));
					}
				}
			}
			
			/*for(int[] m : map) {
				for(int val : m) System.out.print(val);
				System.out.println();
			}*/
			
			int sec=0;
			while(sec<K) {
				bfs();
				sec++;
			}
			sb.append("#").append(t).append(" ").append(q.size()).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
	
	static void bfs() {
		int size = q.size();
		
		for(Cell c : q) {
			if(c.state=="on") check(c);
		}
		
		while(size > 0) {
			Cell cur = q.poll();
			
			// 활성 상태이면 번식
			if(cur.state=="on" && cur.temp==cur.life) {
				for(int d=0; d<4; d++) {
					int nr = cur.r + dr[d];
					int nc = cur.c + dc[d];
					
					if(!v[nr][nc]) {
						v[nr][nc] = true;
						q.offer(new Cell(nr, nc, map[nr][nc], 0, "off"));
					}
				}
			}
			
			cur.setState();
			if(cur.state != "death") {
				q.offer(cur);
			}
			size--;
		}
	}
	
	static void check(Cell cell) {
		for(int d=0; d<4; d++) {
			int nr = cell.r + dr[d];
			int nc = cell.c + dc[d];
			
			if(!v[nr][nc] && map[nr][nc] < cell.life) {
				map[nr][nc] = cell.life;
			}
		}
	}
}
