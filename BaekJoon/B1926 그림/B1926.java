package M03_4;

import java.io.*;
import java.util.*;

public class B1926 {
	static int[] dr = {-1, 0, 1, 0}; //상우하좌
	static int[] dc = {0, 1, 0, -1}; //상우하좌
	
	static int N, M, maxWidth;
	static int[][] map;
	static boolean[][] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		v = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		maxWidth = 0;
		int total = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!v[i][j] && map[i][j] == 1) {
					bfs(i, j);
					total++;
				}
			}
		}
		sb.append(total).append("\n");
		sb.append(maxWidth).append("\n");
		System.out.println(sb.toString());
		br.close();
	}

	static void bfs(int r, int c) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		v[r][c] = true;
		q.offer(new int[] {r,c});
		
		int cnt = 1;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int d=0; d<4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(0<=nr&&nr<N && 0<=nc&&nc<M && !v[nr][nc] && map[nr][nc]==1) {
					v[nr][nc] = true;
					q.offer(new int[] {nr, nc});
					cnt++;
				}
			}
		}
		
		maxWidth = Math.max(maxWidth, cnt);
	}
}
