package M02_4;

import java.io.*;
import java.util.*;

public class B16235 {
	static int[] dr = {-1,0,1,0}; //상우하좌
	static int[] dc = {0,1,0,-1}; //상우하좌
	static boolean[][][] isOpen; //국경 연 나라 확인
	static boolean[][] united; //연합 확인
	static int unitedCnt;
	static List<int[]> uc;
	
	static int[][] world;
	static int N, L, R;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		world = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				world[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt=0;
		while(true) {
			isOpen = new boolean[N][N][4];
			united = new boolean[N][N];
			int isMove = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					isMove += checkOpen(i,j);
				}
			}
			if(isMove == 0) break;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!united[i][j]) {
						uc = new ArrayList<>();
						unitedCnt = 1;
						move(i,j);
					} 
				}
			}
			cnt++;
		}
		System.out.println(cnt);
		br.close();
	}
	
	static int checkOpen(int i, int j) {
		int isMove = 0;
		for(int d=0; d<4; d++) {
			int ni = i + dr[d];
			int nj = j + dc[d];
			
			if(0<=ni&&ni<N && 0<=nj&&nj<N && !isOpen[ni][nj][(d+2)%4]) {
				int gap =  Math.abs(world[i][j] - world[ni][nj]);
				if(L<=gap && gap<=R) {
					isMove++;
					isOpen[i][j][d] = true;
					isOpen[ni][nj][(d+2)%4] = true;
				}
			}
		}
		return isMove;
	}
	
	static void move(int i, int j) {
		// 연합 확인
		Queue<int[]> q = new ArrayDeque<>();
		united[i][j] = true;
		q.add(new int[] {i,j});
		uc.add(new int[] {i,j});
		int unitedPopul = world[i][j];
		
		while(!q.isEmpty()) {
			int[] pos = q.poll();
			
			for(int d=0; d<4; d++) {
				int ni = pos[0] + dr[d];
				int nj = pos[1] + dc[d];
				
				if(0<=ni&&ni<N && 0<=nj&&nj<N && !united[ni][nj] && isOpen[pos[0]][pos[1]][d]) {
					united[ni][nj] = true;
					q.add(new int[] {ni, nj});
					uc.add(new int[] {ni, nj});
					unitedCnt++;
					unitedPopul += world[ni][nj];
				}
			}
		}
		
		// 연합 나라에 인구 이동
		int movePopul = unitedPopul/unitedCnt;
		for(int k=0; k<unitedCnt; k++) {
			int[] country = uc.get(k);
			world[country[0]][country[1]] = movePopul;
		}
	}
}
