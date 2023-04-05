package M04_1;

import java.io.*;
import java.util.*;

public class B7562 {
	static int [] dr = {2,1,2,1,-1,-2,-2,-1}; //10시, 11시, 1시, 2시, 4시, 5시, 7시, 8시
	static int [] dc = {-1,-2,1,2,2,1,-1,-2}; //10시, 11시, 1시, 2시, 4시, 5시, 7시, 8시
	
	static int N;
	static boolean[][] v;
	static int endR, endC;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			v = new boolean[N][N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(), " ");
			endR = Integer.parseInt(st.nextToken());
			endC = Integer.parseInt(st.nextToken());
			sb.append((bfs(r,c))).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	static int bfs(int r, int c) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		v[r][c] = true;
		q.offer(new int[] {r, c, 0});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			if(cur[0]==endR && cur[1]==endC) return cur[2];
			
			for(int d=0; d<8; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(0<=nr&&nr<N && 0<=nc&&nc<N && !v[nr][nc]) {
					v[nr][nc] = true;
					q.offer(new int[] {nr, nc, cur[2]+1});
				}
			}
		}
		return 0;
	}
}