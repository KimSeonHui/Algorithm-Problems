package M02_4;

import java.io.*;
import java.util.*;

public class B15683 {
	static int[] dr = {-1,0,1,0}; // 상우하좌
	static int[] dc = {0,1,0,-1}; // 상우하좌
	
	static int[] b, dir;
	static List<int[]> cctvs;
	static int[][] room, temp;
	static int cctvCnt, ans, N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		room = new int[N][M];
		dir = new int[]{0,1,2,3}; // 상우하좌
		
		
		cctvCnt = 0;
		cctvs = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
				if(room[i][j]!=0 && room[i][j]!=6) { // cctv이면
					cctvs.add(new int[] {i, j, room[i][j]}); //cctv r좌표, cctv c좌표, cctv 번호
					cctvCnt++;
				}
			}
		}
		
		b = new int[cctvCnt];
		ans = Integer.MAX_VALUE;
		perm(0);
		System.out.println(ans);
	}
	
	static void perm(int cnt) {
		if(ans == 0) return;
		if(cnt == cctvCnt) {
			//순열 완성 - cctv 방향마다 확인
			temp = new int[N][M];
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) temp[i][j] = room[i][j];
			}
			
			for(int i=0; i<cctvCnt; i++) {
				int cctvNum = cctvs.get(i)[2];
				int r = cctvs.get(i)[0];
				int c = cctvs.get(i)[1];
				int dir = b[i];
				
				if(cctvNum==1) monitor(r, c, dir);
				else if(cctvNum==2) {
					monitor(r, c, dir);
					monitor(r, c, (dir+2)%4);
				}
				else if(cctvNum==3) {
					monitor(r, c, dir);
					monitor(r, c, (dir+1)%4);
				}
				else if(cctvNum==4) {
					monitor(r, c, dir);
					monitor(r, c, (dir+1)%4);
					monitor(r, c, (dir+2)%4);
				}
				else if(cctvNum==5) {
					monitor(r, c, dir);
					monitor(r, c, (dir+1)%4);
					monitor(r, c, (dir+2)%4);
					monitor(r, c, (dir+3)%4);
				}
			}
			
			ans = getMin();
			return;
		}
		for(int i=0; i<4; i++) {
			b[cnt] = dir[i];
			perm(cnt+1);
		}
	}
	
	static void monitor(int r, int c, int d) {
		while(0<=r&&r<N && 0<=c&&c<M && temp[r][c]!=6) {
			temp[r][c] = -1;
			r += dr[d];
			c += dc[d];
		}
	}
	
	static int getMin() {
		int noSee=0;
		for(int[] r : temp) {
			for(int val : r) if(val==0) noSee++;
		}
		return Math.min(ans, noSee);
	}

}
