package M03_5;

import java.io.*;
import java.util.*;

public class B17070 {
	static int N, ans;
	static int[][] map;
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0,0,1,0);
		System.out.println(ans);
		br.close();
	}
	
	static void dfs(int startR, int startC, int endR, int endC, int dir) {
		if(endR==N-1 && endC==N-1) {
			ans++;
			return;
		}
		
		// 파이프가 현재 가로방향이면
		if(dir==0) {
			//오른쪽으로 이동
			if(endC+1<N && map[endR][endC+1]!=1) {
				dfs(startR, startC+1, endR, endC+1, 0);
			}
			
			//오른쪽 아래 대각선으로 이동
			if(endR+1<N && endC+1<N) {
				if(map[endR+1][endC]!=1 && map[endR][endC+1]!=1 && map[endR+1][endC+1]!=1)
					dfs(startR, startC+1, endR+1, endC+1, 2);
			}
		}
		// 파이프가 현재 세로방향이면
		else if(dir==1) {
			//아래로 이동
			if(endR+1<N && map[endR+1][endC]!=1) {
				dfs(startR+1, startC, endR+1, endC, 1);
			}
			
			//오른쪽 아래 대각선으로 이동
			if(endR+1<N && endC+1<N) {
				if(map[endR+1][endC]!=1 && map[endR][endC+1]!=1 && map[endR+1][endC+1]!=1)
					dfs(startR+1, startC, endR+1, endC+1, 2);
			}
		}
		// 파이프가 현재 대각선방향이면
		else if(dir==2) {
			//오른쪽으로 이동
			if(endC+1<N && map[endR][endC+1]!=1) {
				dfs(startR+1, startC+1, endR, endC+1, 0);
			}
			
			//아래로 이동
			if(endR+1<N && map[endR+1][endC]!=1) {
				dfs(startR+1, startC+1, endR+1, endC, 1);
			}
			
			//오른쪽 아래 대각선으로 이동
			if(endR+1<N && endC+1<N) {
				if(map[endR+1][endC]!=1 && map[endR][endC+1]!=1 && map[endR+1][endC+1]!=1)
					dfs(startR+1, startC+1, endR+1, endC+1, 2);
			}
		}
	}
}