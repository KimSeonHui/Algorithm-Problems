package M04_1;

import java.io.*;
import java.util.*;

public class B3055 {
	static int[] dr = { -1, 0, 1, 0 }; // 상우하좌
	static int[] dc = { 0, 1, 0, -1 }; // 상우하좌

	static int N, M, min;
	static int[][] time;
	static char[][] map;
	static boolean[][] v;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		time = new int[N][M];
		ArrayDeque<int[]> waters = new ArrayDeque<>();
		int r = 0, c = 0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'S') {
					map[i][j] = '.';
					r = i;
					c = j;
				} 
				else if (map[i][j] == '*')waters.offer(new int[] { i, j, 0 });
				time[i][j] = Integer.MAX_VALUE;
			}
		}

		waterBfs(waters);
		min = Integer.MAX_VALUE;
		v = new boolean[N][M];
		bfs(r, c);

		System.out.println(min == Integer.MAX_VALUE ? "KAKTUS" : min);
		br.close();
	}

	static void waterBfs(ArrayDeque<int[]> q) {
		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];

				if (0 <= nr && nr < N && 0 <= nc && nc < M && map[nr][nc] == '.') {
					map[nr][nc] = '*';
					time[nr][nc] = cur[2] + 1;
					q.offer(new int[] { nr, nc, cur[2] + 1 });
				}
			}
		}
	}

	static void bfs(int r, int c) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		v[r][c] = true;
		q.offer(new int[] { r, c, 0 });

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			if (map[cur[0]][cur[1]] == 'D') {
				min = Math.min(min, cur[2]);
				return;
			}

			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];

				if (0 <= nr && nr < N && 0 <= nc && nc < M && !v[nr][nc] && map[nr][nc] != 'X') {
					if (cur[2] + 1 < time[nr][nc] || map[nr][nc] == 'D') {
						v[nr][nc] = true;
						q.offer(new int[] { nr, nc, cur[2] + 1 });
					}
				}
			}
		}
	}
}