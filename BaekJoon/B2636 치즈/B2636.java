package M03_5;

import java.io.*;
import java.util.*;

public class B2636 {
	static int[] dr = {-1,0,1,0}; // 상우하좌
	static int[] dc = {0,1,0,-1}; // 상우하좌
	
	static int R, C, time, cheese, prevCheese;
	static int[][] board;
	static boolean[][] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new int[R][C];
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<C; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cheese = getTotalCheese();
		while(true) {
			melting();
			if(cheese==0) break;
		}
		
		sb.append(time).append("\n").append(prevCheese);
		System.out.println(sb);
		br.close();
	}
	
	static void melting() {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		v = new boolean[R][C];
		v[0][0] = true;
		q.offer(new int[] {0,0});
		time++;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int d=0; d<4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(0<=nr&&nr<R && 0<=nc&&nc<C && !v[nr][nc]) {
					v[nr][nc] = true;
					if(board[nr][nc]==0) {
						q.offer(new int[] {nr,nc});
					}
					else {
						board[nr][nc]=0;
					}
				}
			}
		}
		prevCheese = cheese;
		cheese = getTotalCheese();
	}
	
	static int getTotalCheese() {
		int cnt = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(board[i][j]==1) cnt++;
			}
		}
		return cnt;
	}
}