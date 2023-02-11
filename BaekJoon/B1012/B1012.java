package backjoon;

import java.io.*;
import java.util.*;

public class B1012 {
	static int[] dr = {-1,0,1,0}; //상우하좌
	static int[] dc = {0,1,0,-1}; //상우하좌
	static int M; 
	static int N;
	static int[][] map;
	static boolean[][] v;
	static ArrayDeque<int[]> q;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			v = new boolean[N][M];
			q = new ArrayDeque<>();
			int cabbage = Integer.parseInt(st.nextToken());
			ans = 0;
			
			while(cabbage>0) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				map[y][x] = 1;
				cabbage--;
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] == 1 && !v[i][j]) {
						bfs(i, j);
					}
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());

	}
	
	static void bfs(int i, int j) {
		v[i][j] = true;
		q.add(new int[] {i, j});
		ans++;
		while(q.size() > 0) {
			int[] pos = q.poll();
			
			for(int d=0; d<4; d++) {
				int ni = pos[0] + dr[d];
				int nj = pos[1] + dc[d];
				
				if(0<=ni&&ni<N && 0<=nj&&nj<M && !v[ni][nj] && map[ni][nj] != 0) {
					v[ni][nj] = true;
					q.add(new int[] {ni, nj});
				}
			}
		}
		return;
	}
}
