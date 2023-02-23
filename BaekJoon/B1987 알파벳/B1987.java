package M02_4;

import java.io.*;
import java.util.*;

public class B1987 {
	static int[] dr = { -1, 0, 1, 0 }; // 상우하좌
	static int[] dc = { 0, 1, 0, -1 }; // 상우하좌

	static char[][] board;
	static int R, C, max;
	static boolean[] alpha;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		board = new char[R][C];
		alpha = new boolean[26];

		for (int r = 0; r < R; r++) {
			String str = br.readLine();
			for (int c = 0; c < C; c++) {
				board[r][c] = str.charAt(c);
			}
		}

		max=0;
		dfs(0, 0, 1);
		System.out.println(max);
	}

	static void dfs(int i, int j, int cnt) {
		alpha[board[i][j]-65] = true;
		max = Math.max(max, cnt);

		for (int d = 0; d < 4; d++) {
			int ni = i + dr[d];
			int nj = j + dc[d];

			if (0 <= ni && ni < R && 0 <= nj && nj < C && !alpha[board[ni][nj]-65]) {
				dfs(ni, nj, cnt+1);
                alpha[board[ni][nj]-65] = false;
			}
		}
	}
}
