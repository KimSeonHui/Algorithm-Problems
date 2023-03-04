package M03_1;

import java.io.*;
import java.util.*;

public class SW1767_2 {
	static int[] dr = {-1,0,1,0}; // 상우하좌
	static int[] dc = {0,1,0,-1}; // 상우하좌
	
	static int N, maxCore, sum;
	static int[][] map;
	static boolean[] v;
	static boolean[][] mapVis;
	static List<int[]> cores;
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
					if(0<i&&i<N && 0<j&&j<N && map[i][j]==1) cores.add(new int[] {i,j});
				}
			}
			v = new boolean[cores.size()];
			
			maxCore=Integer.MIN_VALUE; sum = Integer.MAX_VALUE;
			subs(0, 0);
			sb.append("#").append(t).append(" ").append(sum).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
	
	static void subs(int cnt, int core) {
		if(sum != Integer.MAX_VALUE) return;
		if(cnt == cores.size()) {
			// 부분 집합이 완성 되었을 때
			setLine(0, 0, core, 0); // cnt, start, selectedCore, len
			return;
		}
		
		v[cnt] = true;
		subs(cnt+1, core+1);
		v[cnt] = false;
		subs(cnt+1, core);
	}
	
	static void setLine(int cnt, int start, int core, int len) {
		if(cnt==core) {
			if(maxCore < core) {
				maxCore = core;
				sum = len;
			}
			else if(maxCore==core) {
				sum = Math.min(sum, len);
			}
			return;
		}
		
		for(int i=start; i<cores.size(); i++) {
			// 선택된 코어라면 
			if(v[i]) {
				//4방으로 전선 놓기
				int r = cores.get(i)[0];
				int c = cores.get(i)[1];
				for(int d=0; d<4; d++) {
					boolean isSet=true;
					
					int nr = r + dr[d];
					int nc = c + dc[d];
					while(true) {
						if(nr<0 || N<=nr || nc<0 || N<=nc)  break;
						if(0<=nr&&nr<N && 0<=nc&&nc<N && map[nr][nc]!=0) {
							isSet = false;
							break;
						}
						nr += dr[d];
						nc += dc[d];
					}
					if(!isSet) continue;
					
					// 전선 놓기
					int line=0;
					nr = r + dr[d];
					nc = c + dc[d];
					while(0<=nr&&nr<N && 0<=nc&&nc<N && map[nr][nc]==0) {
						map[nr][nc] = 2;
						line++;
						nr += dr[d];
						nc += dc[d];
					}
					
					//다음 코어 전선 놓기
					setLine(cnt+1, i+1, core, len+line);
					
					// 깔았던 전선 치우기
					nr = r + dr[d];
					nc = c + dc[d];
					while(0<=nr&&nr<N && 0<=nc&&nc<N && map[nr][nc]==2) {
						map[nr][nc] = 0;
						nr += dr[d];
						nc += dc[d];
					}
				}
			}
		}
	}
}
