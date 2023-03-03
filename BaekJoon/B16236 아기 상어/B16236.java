package M03_1;

import java.io.*;
import java.util.*;

public class B16236 {
	static int[] dr = { -1, 0, 0, 1 }; // 상좌우하
	static int[] dc = { 0, -1, 1, 0 }; // 상좌우하

	static int[][] map;
	static boolean[][] v;
	static int N, ans;
	static int[] shark;
	static PriorityQueue<int[]> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		v = new boolean[N][N];
		shark = new int[4]; // r , c , 현재 크기, 먹은 물고기 수
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					shark[0] = i;
					shark[1] = j;
					shark[2] = 2; // 크기
					shark[3] = 0; // 먹은 물고기 수
				}
			}
		}

		ans = 0;
		q = new PriorityQueue<>((o1, o2) -> {
			int r = Integer.compare(o1[2], o2[2]);
			if (r == 0) {
				r = Integer.compare(o1[0], o2[0]);
				if (r == 0)
					r = Integer.compare(o1[1], o2[1]);
			}
			return r;
		});

		bfs(shark[0], shark[1]);
		System.out.println(ans);
	}

	static void bfs(int i, int j) {
		map[i][j] = 0;
		q.offer(new int[] { i, j, 0 }); // r, c

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			if (v[cur[0]][cur[1]]) continue;
			v[cur[0]][cur[1]] = true;
			int depth = cur[2];

			if (map[cur[0]][cur[1]] != 0 && map[cur[0]][cur[1]] < shark[2]) { // 먹을 수 있는 물고기이면
				// 이동 후 먹기
				map[cur[0]][cur[1]] = 0;
				//shark[0]=cur[0];
				//shark[1]=cur[1];
				ans += depth; // 이동한 만큼 시간 증가

				shark[3]++; // 먹은 물고기 수 증가
				if (shark[3] == shark[2]) { // 먹은 물고기가 현재 크기와 같으면 상어 크기 증가
					shark[2]++;
					shark[3] = 0;
				}

				q.clear();
				v = new boolean[N][N];
				depth = 0;
				q.offer(new int[] { cur[0], cur[1], 0 });
			}
			else {
				for (int d = 0; d < 4; d++) {
					int ni = cur[0] + dr[d];
					int nj = cur[1] + dc[d];

					// 범위 안에 있고, 이동할 수 있으면
					if (0 <= ni && ni < N && 0 <= nj && nj < N && !v[ni][nj] && map[ni][nj] <= shark[2]) {
						q.offer(new int[] { ni, nj, depth + 1 });
					}
				}
			}

		}
	}
}
