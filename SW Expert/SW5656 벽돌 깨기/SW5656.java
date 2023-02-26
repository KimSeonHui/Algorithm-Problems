package M02_4;

import java.io.*;
import java.util.*;

public class SW5656 {
	static int[] res;
	
	static int N,W,H, min;
	static int[][] board, temp;
	static int[] dr = {-1,0,1,0}; // 상우하좌
	static int[] dc = {0,1,0,-1}; // 상우하좌
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/input_sw5656.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			board = new int[H][W];
			for(int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<W; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			res = new int[N];
			min = Integer.MAX_VALUE;
			perm(0);
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
	
	static void perm(int cnt) {
		if(min == 0) return;
		if(cnt == N) {
			//중복 순열 완성
			temp = new int[H][W];
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) temp[i][j] = board[i][j];
			}
			min = Math.min(min, breakBlock());
			return;
		}
		
		for(int i=0; i<W; i++) {
			res[cnt] = i;
			perm(cnt+1);
		}
	}
	
	static int breakBlock() {
		for(int p=0; p<N; p++) {
			int shootPos = res[p];
			
			for(int i=0; i<H; i++) {
				if(temp[i][shootPos] != 0) { // 벽돌이 있으면
					explosion(i,shootPos, temp[i][shootPos]-1);
					moveDown();
					break; // 한 번 벽돌 깨면 다음 위치로 이동
				}
			}
		}
		
		// 남은 벽돌 세기
		int ans = 0;
		for(int[] m : temp) {
			for(int val : m) {
				if(val != 0) ans++;
			}
		}
		return ans;
	}
	
	static void explosion(int r, int c, int val) {
		temp[r][c] = 0;
		if(val == 0) return;
		
		// 폭발로 깨지는 블럭들
		for(int k=1; k<=val; k++) {
			for(int d=0; d<4; d++) {
				int ni = r + dr[d]*k;
				int nj = c + dc[d]*k;
				
				// 범위 안에 있고, 벽돌이면
				if(0<=ni&&ni<H && 0<=nj&&nj<W && temp[ni][nj]!=0) {
					explosion(ni, nj, temp[ni][nj]-1);
				}
			}
		}
	}
	
	static void moveDown() {
		for(int j=0; j<W; j++) { // 모든 열 확인
			int startR = H-1; // 시작점은 마지막으로 초기화
			
			// 0인 위치 찾기
			for(int i=startR; i>=0; i--) {
				if(temp[i][j]==0) {
					startR = i;
					break;
				}
			}
			
			// 벽돌이면 시작점과 위치 바꾸기
			for(int i=startR-1; i>=0; i--) {
				if(temp[i][j]!=0 && temp[startR][j]==0){
					temp[startR][j] = temp[i][j];
					temp[i][j]=0;
					startR--;
				}
			}
		}
	}
}
