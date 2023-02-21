package M02_4;

import java.io.*;
import java.util.*;

public class B3019 {
	static int[] dr = {-1,0,1}; //우상 , 우, 우하
	
	static int R,C;
	static char[][] map;
	static boolean[][] v;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		v = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		ans = 0;
		for(int i=0; i<R; i++) {
			if(v[i][0]) continue;
			if(setPipe(i,0)) ans++;
		}
		System.out.println(ans);
	}
	
	static boolean setPipe(int r, int cnt) {
		v[r][cnt] = true;
		if(cnt == C-1) return true;
		
		for(int d=0; d<3; d++) {
			int ni = r + dr[d];
			int nj = cnt + 1;
			
			// 범위를 벗어나지 않고, 아직 파이프가 설치 되어 있지 않고 다음 설치할 칸에 건물이 없으면
			if(0<=ni&&ni<R && nj<C && !v[ni][nj] && map[ni][nj] != 'x') {
				if(setPipe(ni, nj)) return true;
			}
		}
		return false;
	}
}
