package M03_1;

import java.io.*;
import java.util.*;

public class SW4014 {
	static int N, L, ans;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/input_sw4014.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			ans=0;
			for(int i=0; i<N; i++) {
				if(checkPath(i,0, 'R')) ans++;
				if(checkPath(0,i, 'C')) ans++;
			}
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}

	static boolean checkPath(int r, int c, char dir) {
		boolean[] v = new boolean[N];
		int[] path = new int[N];
		
		for(int i=0; i<N; i++) {
			if(dir=='R') path[i] = map[r][i];
			else path[i] = map[i][c];
		}
		
		for(int i=0; i+1<N; i++) {
			if(path[i]==path[i+1]) continue;
			
			// 올라가는 경사 :: 작은 수 > 큰 수
			else if(path[i] - path[i+1] == -1) {
				for(int x=0; x<L; x++) {
					if(0<=i-x&&i-x<N && !v[i-x] && path[i]==path[i-x]) v[i-x] = true;
					else return false;
				}
			}
			
			// 내려가는 경사 :: 큰 수 > 작은 수
			else if(path[i] - path[i+1] == 1) {
				for(int x=1; x<=L; x++) {
					if(0<=i+x&&i+x<N && !v[i+x] && path[i+1]==path[i+x]) v[i+x] = true;
					else return false;
				}
			}
			
			// 높이가 2이상 차이나는 경우
			else return false;
		}
		return true;
	}
}
