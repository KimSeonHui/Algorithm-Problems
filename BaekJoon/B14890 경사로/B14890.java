package backjoon;

import java.io.*;
import java.util.*;

public class B14890 {
	static int[][] map;
	static boolean[][] v;
	static int N;
	static int L;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int ans = 0;
		v = new boolean[N][N];
		for (int i = 0; i < N; i++) {
				if (check(i,0,'R')) ans++; // 행 탐색
				if (check(0,i,'C')) ans++; // 열 탐색
		}
		System.out.println(ans);
	}
	
	static boolean check(int r, int c, char dir) {
		int[] path = new int[N];
		boolean[] visited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			if(dir == 'R') path[i] = map[r][i];
			else path[i] = map[i][c];
		}
		
		for(int i=0; i+1<N; i++) {
			if(path[i] == path[i+1]) continue; // 높이가 같을 때 > 통과
			
			// 작은 수 > 큰수 :: 올라가는 경사 > 경사로 놓을 수 있는지 확인
			if (path[i] - path[i+1] == -1) {
				for (int k=0; k <L; k++) { 
					if (i-k<0 || visited[i-k] || path[i] != path[i-k]) return false;
					else visited[i-k] = true;;
				}
			}
			
			// 큰 수 > 작은 수 :: 내려가는 경사 > 경사로 놓을 수 있는지 확인
			else if (path[i] - path[i+1] == 1) {
				for (int k = 1; k <= L; k++) {
					if (N<=i+k || visited[i+k] || path[i+1] != path[i+k]) return false;
					else visited[i+k] = true;
				}
			}
			
			else return false; // 높이가 2이상 차이날 때
		}
		return true;
	}
}
