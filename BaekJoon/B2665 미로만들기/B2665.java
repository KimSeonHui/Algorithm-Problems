package M03_3;

import java.io.*;
import java.util.*;

public class B2665 {
	static int[] dr = {-1,0,1,0}; // 상우하좌
	static int[] dc = {0,1,0,-1}; // 상우하좌
	
	static int N, ans;
	static int[][] map, dist;
	static boolean[][] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		dist = new int[N][N];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				int num = str.charAt(j) - '0';
				
				// 검은색 - 1, 흰색 - 0
				if(num==1) map[i][j] = 0;
				else map[i][j] = 1;
				
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		
		v = new boolean[N][N];
		bfs(0, 0);
		System.out.println(dist[N-1][N-1]);
		br.close();
	}
	
	static void bfs(int r, int c) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
		dist[r][c] = 0;
		pq.offer(new int[] {r,c, dist[r][c]});
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int curR = cur[0];
			int curC = cur[1];
			
			if(v[curR][curC]) continue;
			v[curR][curC] = true;
			
			for(int d=0; d<4; d++) {
				int nr = curR + dr[d];
				int nc = curC + dc[d];
				
				if(0<=nr&&nr<N && 0<=nc&&nc<N) {
					if(!v[nr][nc] && dist[nr][nc] > dist[cur[0]][cur[1]] + map[nr][nc]) {
						dist[nr][nc] = dist[cur[0]][cur[1]] + map[nr][nc];
						pq.offer(new int[] {nr, nc, dist[nr][nc]});
					}
				}
			}
		}
	}
}