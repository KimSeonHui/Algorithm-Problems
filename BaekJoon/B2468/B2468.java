package backjoon;

import java.io.*;
import java.util.*;

public class B2468 {
	static int[] dr = { -1, 0, 1, 0 }; // 상우하좌
	static int[] dc = { 0, 1, 0, -1 }; // 상우하좌
	static int N;
	static int[][] cheese;
	static boolean[][] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		cheese = new int[N][N];
		int maxDay = 0;
		int maxCnt = 1; // 0일째는 1덩어리아닌가?

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
				maxDay = Math.max(maxDay, cheese[i][j]);
			}
		}

		int day = 1;
		while (day < maxDay) {
			int cheeseCnt = 0;
			v = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (cheese[i][j] > day && !v[i][j]) {
						dfs(i, j, day);
						cheeseCnt++;
					}
				}
			}
			maxCnt = Math.max(maxCnt, cheeseCnt);
			day++;
		}
		sb.append(maxCnt).append("\n");
		System.out.println(sb.toString());
	}

	static void dfs(int i, int j, int day) {
		v[i][j] = true;

		for (int d = 0; d < 4; d++) {
			int ni = i + dr[d];
			int nj = j + dc[d];

			if (0 <= ni && ni < N && 0 <= nj && nj < N && !v[ni][nj] && cheese[ni][nj] > day) {
				v[ni][nj] = true;
				dfs(ni, nj, day);
			}
		}
	}
}
