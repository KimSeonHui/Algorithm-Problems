package backjoon;

import java.io.*;
import java.util.*;

class Town {
	int townNum;
	int houseCnt;
	
	public Town(int num, int cnt) {
		townNum = num;
		houseCnt = cnt;
	}
}

public class B2667 {
	static int[] dr = {-1,0,1,0}; // 상우하좌
	static int[] dc = {0,1,0,-1}; // 상우하좌
	static int[][] map;
	static boolean[][] v;
	static int townNum = 0;
	static int houseCnt = 1;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		List<Town> list = new ArrayList<>();
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		v = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!v[i][j] && map[i][j] == 1) {
					townNum++;
					houseCnt=1;
					//bfs(i, j);
					dfs(i,j);
					list.add(new Town(townNum, houseCnt));
				}
			}
		}
		
		sb.append(townNum).append("\n");
		Collections.sort(list, (o1, o2) -> Integer.compare(o1.houseCnt, o2.houseCnt));
		
		for(Town t : list) sb.append(t.houseCnt).append("\n");
		System.out.println(sb.toString());
		
	}
	
	static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		v[i][j] = true;
		q.offer(new int[]{i,j});
		while(!q.isEmpty()) {
			int[] pos = q.poll();
			
			for(int d=0; d<4; d++) {
				int ni = pos[0] + dr[d];
				int nj = pos[1] + dc[d];
				
				if(0<=ni&&ni<N && 0<=nj&&nj<N && !v[ni][nj] && map[ni][nj] == 1) {
					v[ni][nj] = true;
					q.offer(new int[] {ni,nj});
					houseCnt++;
				}
			}
		}
	}
	
	static void dfs(int i, int j) {
		v[i][j] = true;
		for(int d=0; d<4; d++) {
			int ni = i + dr[d];
			int nj = j + dc[d];
			
			if(0<=ni&&ni<N && 0<=nj&&nj<N && !v[ni][nj] && map[ni][nj] == 1) {
				dfs(ni, nj);
				houseCnt++;
			}
		}
	}

}
