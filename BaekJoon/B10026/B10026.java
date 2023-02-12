package backjoon;

import java.io.*;
import java.util.*;

public class B10026 {
	static int[] dr = {-1,0,1,0}; // 상우하좌
	static int[] dc = {0,1,0,-1}; // 상우하좌
	
	static int N;
	static char[][] picture;
	static boolean[][] normalV;
	static boolean[][] rgV;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		N = Integer.parseInt(br.readLine());
		picture = new char[N][N];
		normalV = new boolean[N][N];
		rgV = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				picture[i][j] = s.charAt(j);
			}
		}
		
		int normalCnt = 0;
		int rgCnt = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!normalV[i][j]) {
					bfsNormal(i,j, picture[i][j]);
					normalCnt++;
				}
				if(!rgV[i][j]) {
					bfsRG(i,j, picture[i][j]);
					rgCnt++;
				}
			}
		}
		sb.append(normalCnt).append(" ").append(rgCnt);
		System.out.println(sb.toString());
	}
	
	static void bfsNormal(int i, int j, char color) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		normalV[i][j] = true;
		q.add(new int[] {i, j});
		while(q.size() > 0) {
			int[] pos = q.poll();
			
			for(int d =0; d<4; d++) {
				int ni = pos[0] + dr[d];
				int nj = pos[1] + dc[d];
				
				if(0<=ni&&ni<N && 0<=nj&&nj<N && !normalV[ni][nj] && picture[ni][nj]==color) {
					normalV[ni][nj] = true;
					q.add(new int[] {ni, nj});
				}
			}
		}
	}
	
	static void bfsRG(int i, int j, char color) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		rgV[i][j] = true;
		q.add(new int[] {i, j});
		while(q.size() > 0) {
			int[] pos = q.poll();
			
			for(int d =0; d<4; d++) {
				int ni = pos[0] + dr[d];
				int nj = pos[1] + dc[d];
				
				if(0<=ni&&ni<N && 0<=nj&&nj<N && !rgV[ni][nj]) {
					if((color == 'R' || color == 'G') && (picture[ni][nj] == 'R' || picture[ni][nj] == 'G')
						|| color == 'B' && picture[ni][nj] == 'B') {
						rgV[ni][nj] = true;
						q.add(new int[] {ni, nj});
					}
				}
			}
		}
	}

}
