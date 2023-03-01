package M03_1;

import java.io.*;
import java.util.*;

public class B2178 {
	static int[] dr = {-1,0,1,0}; // 상우하좌
	static int[] dc = {0,1,0,-1}; // 상우하좌
	
	static int N, M, depth;
	static int[][] map;
	static boolean[][] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		v = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		depth=1;
		bfs(0,0);
		System.out.println(depth+1);
	}
	
	static void bfs(int i, int j) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		v[i][j] = true;
		q.add(new int[] {i,j});
		
		int size = 0;
		while(!q.isEmpty()) {
			size = q.size();
			while(size > 0) {
				int[] pos = q.poll();
				
				for(int d=0; d<4; d++) {
					int ni = pos[0] + dr[d];
					int nj = pos[1] + dc[d];
					
					if(0<=ni&&ni<N && 0<=nj&&nj<M && !v[ni][nj] && map[ni][nj]==1) {
						v[ni][nj] = true;
						q.add(new int[]{ni, nj});
						if(ni==N-1 && nj==M-1) return;
					}
				}
				size--;
			}
			depth++;
		}
	}

}
