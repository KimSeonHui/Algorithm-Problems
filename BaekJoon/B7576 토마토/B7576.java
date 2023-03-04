package M03_1;

import java.io.*;
import java.util.*;

public class B7576 {
	static int[] dr = {-1,0,1,0}; // 상우하좌
	static int[] dc = {0,1,0,-1}; // 상우하좌
	
	static int N, M, ans;
	static int[][] map;
	static boolean[][] v;
	static ArrayDeque<int[]> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		v = new boolean[N][M];
		q = new ArrayDeque<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					v[i][j] = true;
					q.offer(new int[] {i,j,0});
				}
			}
		}
		
		bfs();
		
		for(int[] m : map) {
			for(int val : m) if(val==0) ans=-1;
		}
		System.out.println(ans);
		br.close();
	}
	
	static void bfs() {
		int depth = 0;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			depth = cur[2];
			
			for(int d=0; d<4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				//범위 안에 있고, 방문하지 않았고, 안 익은 토마토이면
				if(0<=nr&&nr<N && 0<=nc&&nc<M && !v[nr][nc] && map[nr][nc]==0) {
					v[nr][nc] = true;
					map[nr][nc]=1;
					q.offer(new int[] {nr,nc,depth+1});
				}
			}
		}
		ans = depth;
	}
}










