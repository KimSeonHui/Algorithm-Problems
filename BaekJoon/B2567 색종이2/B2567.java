package M02_4;

import java.io.*;
import java.util.*;

public class B2567 {
	static int[] dr = {-1,0,1,0};// 상우하좌
	static int[] dc = {0,1,0,-1};// 상우하좌
	static boolean[][] v;
	static int[][] map;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[101][101];
		v = new boolean[101][101];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int L = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			for(int r=B; r<B+10; r++) {
				for(int c=L; c<L+10; c++) {
					map[r][c]=1;
				}
			}
		}
		
		cnt = 0;
		for(int i=1; i<=100; i++) {
			for(int j=1; j<=100; j++) {
				if(map[i][j]==1) {
					for(int d=0; d<4; d++) {
						int ni = i + dr[d];
						int nj = j + dc[d];
						
						if(1<=ni&&ni<=100 && 1<=nj&&nj<=100 && map[ni][nj]==0) cnt++;
						else if(ni<1 || ni>100 || nj<1 || nj>100) cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
	}
	
}
