package backjoon;

import java.io.*;
import java.util.*;

public class B17144 {
	static int[] dr = { 0, -1, 0, 1 }; // 우상좌하
	static int[] dc = { 1, 0, -1, 0 }; // 우상좌하
	static int[][] room;
	static int R, C;
	static int airUp, airDown;
	static ArrayDeque<int[]> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); // 행 길이
		C = Integer.parseInt(st.nextToken()); // 열 길이
		int T = Integer.parseInt(st.nextToken()); // 초
		airUp = 0; // 공기청정기 위쪽 위치
		airDown = 0; // 공기 청정기 아래쪽 위치
		q = new ArrayDeque<>(); // 미세먼지 정보 저장
		room = new int[R][C]; // 방 정보 저장

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
				if (room[i][j] == -1 && airUp == 0) {
					airUp = i;
					airDown = i + 1;
				}
			}
		}

		int sec = 0;
		while (sec < T) {
			// 미세먼지 있는 곳 체크
			checkDust();
			
			// 미세먼지 확산
			spread();

			// 공기청정기 작동
			airClean();
			sec++;
		}

		int sum = 0;
		for (int[] r : room) {
			for (int val : r)
				sum += val;
		}
		System.out.println(sum + 2);
	}

	static void checkDust() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (room[i][j] < 5) continue;
				q.offer(new int[] { i, j, room[i][j] }); // r, c, 미세먼지 양
			}
		}
	}

	static void spread() {
		while (!q.isEmpty()) {
			int[] val = q.poll();
			int cnt = 0; // 확산된 방향 개수
			int spreadDust = val[2]/5;
			for (int d = 0; d < 4; d++) {
				int ni = val[0] + dr[d];
				int nj = val[1] + dc[d];

				if (0 <= ni && ni < R && 0 <= nj && nj < C && room[ni][nj] != -1) {
					cnt++;
					room[ni][nj] += spreadDust;
				}
			}
			room[val[0]][val[1]] -= spreadDust * cnt;
		}
	}

	static void airClean() {
		// 위쪽 공기 회전
		for (int i = airUp - 1; i > 0; i--) { // V
			room[i][0] = room[i - 1][0];
		}
		for (int i = 1; i < C; i++) { // <
			room[0][i - 1] = room[0][i];
		}
		for (int i = 1; i <= airUp; i++) { // ^
			room[i - 1][C - 1] = room[i][C - 1];
		}
		for (int i = C - 1; i > 0; i--) { // >
			if(i==1) room[airUp][i] = 0;
			else room[airUp][i] = room[airUp][i - 1];
		}

		// 아래쪽 공기 회전
		for (int i = airDown + 2; i <= R - 1; i++) { // ^
			room[i - 1][0] = room[i][0];
		}
		for (int i = 1; i < C; i++) { // <
			room[R - 1][i - 1] = room[R - 1][i];
		}
		for (int i = R - 1; i > airDown; i--) { // V
			room[i][C - 1] = room[i - 1][C - 1];
		}
		for (int i = C - 1; i > 0; i--) { // >
			if(i==1) room[airDown][i] = 0;
			else room[airDown][i] = room[airDown][i - 1];
		}
	}

}
