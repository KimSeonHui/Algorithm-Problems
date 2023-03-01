package M03_1;

import java.io.*;
import java.util.*;

public class SW1953 {
	static int[] dr = {-1,0,1,0}; // 상우하좌
	static int[] dc = {0,1,0,-1}; // 상우하좌
	static int[] dir = {0,1,2,3}; // 상우하좌
	
	static int N, M, L, ans;
	static int[][] map;
	static boolean[][] v;
	
	static ArrayDeque<int[]> q;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/input_sw1953.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 세로 길이
			M = Integer.parseInt(st.nextToken()); // 가로 길이
			int r = Integer.parseInt(st.nextToken()); // 시작 r 좌표
			int c = Integer.parseInt(st.nextToken()); // 시작 c 좌표
			L = Integer.parseInt(st.nextToken()); // 탈출 후 소요된 시간
			
			map = new int[N][M];
			v = new boolean[N][M];
			
			//지도 정보 입력 받기
			int startPipe=0;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] != 0) {
						if(i==r && c==j) startPipe = map[i][j];
					}
				}
			}
			
			// 이동 가능한 파이프 찾기
			q = new ArrayDeque<>();
			bfs(r, c, startPipe);
			
			
			//탈출범이 있는 장소 카운트
			ans=0;
			for(boolean[] vis : v) {
				for(boolean val : vis) if(val) ans++;
			}
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
	
	static void bfs(int i, int j, int pipeNum) {
		v[i][j] = true;
		q.add(new int[] {i,j, pipeNum}); // r, c, 파이프 번호
		
		int size=0, depth=1;
		while(!q.isEmpty()) {
			if(depth==L) break;
			size = q.size();
			while(size > 0) {
				int[] pos = q.poll();
				
				if(pos[2]==1) {
					move(pos[0], pos[1], dir[0]);
					move(pos[0], pos[1], dir[1]);
					move(pos[0], pos[1], dir[2]);
					move(pos[0], pos[1], dir[3]);
				}
				else if(pos[2]==2) {
					move(pos[0], pos[1], dir[0]);
					move(pos[0], pos[1], dir[2]);
				}
				else if(pos[2]==3) {
					move(pos[0], pos[1], dir[1]);
					move(pos[0], pos[1], dir[3]);
				}
				else if(pos[2]==4) {
					move(pos[0], pos[1], dir[0]);
					move(pos[0], pos[1], dir[1]);
				}
				else if(pos[2]==5) {
					move(pos[0], pos[1], dir[1]);
					move(pos[0], pos[1], dir[2]);
				}
				else if(pos[2]==6) {
					move(pos[0], pos[1], dir[2]);
					move(pos[0], pos[1], dir[3]);
				}
				else if(pos[2]==7) {
					move(pos[0], pos[1], dir[0]);
					move(pos[0], pos[1], dir[3]);
				}
				size--;
			}
			depth++;
		}
	}
	
	static void move(int i, int j, int d) {
		int ni = i + dr[d];
		int nj = j + dc[d];
		
		if(0<=ni&&ni<N && 0<=nj&&nj<M && !v[ni][nj] && map[ni][nj]!=0) {
			if(isConnect(map[ni][nj], (d+2)%4)) {
				v[ni][nj] = true;
				q.add(new int[] {ni, nj, map[ni][nj]});
			}
		}
	}
	
	static boolean isConnect(int pipeNum, int opsiteDir) {
		if(pipeNum==1) {
			if(dir[0]==opsiteDir || dir[1]==opsiteDir || dir[2]==opsiteDir || dir[3]==opsiteDir) return true;
		}
		else if(pipeNum==2) {
			if(dir[0]==opsiteDir || dir[2]==opsiteDir) return true;
		}
		else if(pipeNum==3) {
			if(dir[1]==opsiteDir || dir[3]==opsiteDir) return true;
		}
		else if(pipeNum==4) {
			if(dir[0]==opsiteDir || dir[1]==opsiteDir) return true;
		}
		else if(pipeNum==5) {
			if(dir[1]==opsiteDir || dir[2]==opsiteDir) return true;
		}
		else if(pipeNum==6) {
			if(dir[2]==opsiteDir || dir[3]==opsiteDir) return true;
		}
		else if(pipeNum==7) {
			if(dir[0]==opsiteDir || dir[3]==opsiteDir) return true;
		}
		return false;
	}
}
