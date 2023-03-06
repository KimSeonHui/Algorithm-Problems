package M03_2;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class SW1249 {
	static int[] dr= {-1,0,1,0}; // 상우하좌
	static int[] dc= {0,1,0,-1}; // 상우하좌
	
	static int N;
	static int[][] map, dis;
	static boolean[][] v;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/input_sw1249.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			dis = new int[N][N];
			v = new boolean[N][N];
			
			for(int i=0; i<N; i++) {
				String str = br.readLine();
				for(int j=0; j<N; j++) {
					map[i][j] = str.charAt(j) - '0';
					dis[i][j] = Integer.MAX_VALUE;
				}
			}
			
			dis[0][0] = 0;
			bfs(0,0);
			sb.append("#").append(t).append(" ").append(dis[N-1][N-1]).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
		
	}
	
	static void bfs(int r, int c) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		v[r][c] = true;
		q.offer(new int[] {r, c});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int d=0; d<4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(0<=nr&&nr<N && 0<=nc&&nc<N) {
					if(!v[nr][nc]) {
						v[nr][nc] = true;
					}
					if(dis[nr][nc] > dis[cur[0]][cur[1]] + map[nr][nc]) {
						dis[nr][nc] = dis[cur[0]][cur[1]] + map[nr][nc];
						q.offer(new int[] {nr, nc});
					}
					//print();
				}
			}
		}
	}
	
	static void print() {
		for(int[] m : dis) {
			for(int val : m) System.out.print(val + " ");
			System.out.println();
		}
		System.out.println();
	}

}
