package M03_1;

import java.io.*;
import java.util.*;

public class SW1767 {
	static int[] dr = {-1,0,1,0}; // 상우하좌
	static int[] dc = {0,1,0,-1}; // 상우하좌
	
	static int N, maxCore, len;
	static List<int[]> cores;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/input_sw1767.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			cores = new ArrayList<>();
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]==1) {
						if(0<i&&i<N-1 && 0<j&&j<N-1) cores.add(new int[] {i,j}); // 가장 자리가 아닌 코어만 선택
					}
				}
			}
			
			maxCore=Integer.MIN_VALUE; len=Integer.MAX_VALUE;
			subs(0, 0, 0);
			sb.append("#").append(t).append(" ").append(len).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}

	static void subs(int cnt, int core, int sum) { // cnt : 선택한 요소 수 , core : 전원을 연결한 코어 수 , sum : 연결한 코어의 전선 길이의 합
		if(cnt==cores.size()) {
			// 부분 집합이 완성 됐을 때
			if(core < maxCore) return;

			if(maxCore < core) {
				maxCore = core;
				len = sum;
			}
			else if(maxCore == core) {
				len = Math.min(len, sum);
			}
			return;
		}
		
		int r = cores.get(cnt)[0];
		int c = cores.get(cnt)[1];
		
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			boolean isSet=true;
			while(true) {
				if(nr<0 || N<=nr || nc<0 || N<=nc) break;	
				if(0<=nr&&nr<N && 0<=nc&&nc<N && map[nr][nc]!=0) {
					isSet=false;
					break;
				}
				nr += dr[d];
				nc += dc[d];
			}
			if(!isSet) continue;
			
			// 해당 방향으로 전선 놓기
			nr = r + dr[d];
			nc = c + dc[d];
			int line=0;
			while(0<=nr&&nr<N && 0<=nc&&nc<N && map[nr][nc]==0) {
				map[nr][nc] = 2;
				line++;
				nr += dr[d];
				nc += dc[d];
			}
			
			// 다음 코어 선택하기 - 현재 코어를 선택한 경우
			subs(cnt+1, core+1, sum+line);
			
			// 해당 코어로 할 수 있는 게 모두 끝났을 때 원상 복구
			nr = r + dr[d];
			nc = c + dc[d];
			while(0<=nr&&nr<N && 0<=nc&&nc<N && map[nr][nc]!=0) {
				map[nr][nc] = 0;
				line--;
				nr += dr[d];
				nc += dc[d];
			}
		}
		// 다음 코어 선택하기 - 현재 코어 선택하지 않은 경우
		subs(cnt+1, core, sum);
	}
}
