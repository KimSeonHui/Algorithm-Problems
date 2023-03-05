package M03_2;

import java.io.*;
import java.util.*;

public class B7569 {
	static int[] dh = {-1,1,0,0,0,0}; // 위 아래 왼 오 앞 뒤
	static int[] dr = {0,0,-1,0,1,0}; // 위 아래 왼 오 앞 뒤
	static int[] dc = {0,0,0,1,0,-1}; // 위 아래 왼 오 앞 뒤
	
	static int N, M, H, ans;
	static int[][][] map;
	static boolean[][][] v;
	static ArrayDeque<int[]> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		
		map = new int[H][N][M];
		v = new boolean[H][N][M];
		q = new ArrayDeque<>();
		for(int h=0; h<H; h++) {
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<M; j++) {
					map[h][i][j] = Integer.parseInt(st.nextToken());
					if(map[h][i][j]==1) {
						v[h][i][j]=true;
						q.offer(new int[] {h, i, j, 0});
					}
				}
			}
		}
		bfs();
		System.out.println(ans);
		br.close();
	}
	
	static void bfs() {
		int depth=0;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int h = cur[0];
			int r = cur[1];
			int c = cur[2];
			depth = cur[3];
			
			for(int d=0; d<6; d++) {
				int nh = h+dh[d];
				int nr = r+dr[d];
				int nc = c+dc[d];
				
				if(0<=nh&&nh<H&& 0<=nr&&nr<N && 0<=nc&&nc<M && !v[nh][nr][nc] && map[nh][nr][nc]==0) {
					v[nh][nr][nc] = true;
					map[nh][nr][nc] = 1;
					q.offer(new int[] {nh, nr, nc, depth+1});
				}
			}
		}
		
		for(int[][] box : map) {
			for(int[] row : box) {
				for(int val : row) if(val==0) {
					ans=-1;
					return;
				}
			}
		}
		ans = depth;
	}
}
