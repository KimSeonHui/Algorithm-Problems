package M03_2;

import java.io.*;
import java.util.*;

public class B17281 {
	static int N, max;
	static int[][] players;
	static int[] b, res;
	static boolean[] v, ground;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		players = new int[N][10];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <=9; j++) {
				players[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		b = new int[8];
		res = new int[10];
		v = new boolean[10];
		perm(0);
		System.out.println(max);
		br.close();
	}

	static void perm(int cnt) {
		if (cnt == 8) {
			// 순열 완성
			for(int i=0; i<3; i++) {
				res[i] = b[i];
			}
			res[3] = 1;
			for(int i=4; i<9; i++) {
				res[i] = b[i-1];
			}
			playRound();
			return;
		}

		for (int i = 2; i <= 9; i++) {
			if (v[i]) continue;

			v[i] = true;
			b[cnt]=i;
			perm(cnt + 1);
			v[i] = false;
		}
	}

	static void playRound() {
		// 아웃 횟수, 현재 타석에 있는 플레이어, 현재 이닝 , 점수
		int out = 0;
		int curPlayer = 0;
		int curRound = 0;
		int score = 0;
		ground = new boolean[4]; // 0: 홈 , 1: 1루, 2: 2루, 3: 3루

		while (curRound < N) {
			int hit = players[curRound][res[curPlayer]];
			if (hit == 0) { // 아웃
				if (++out == 3) {
					curRound++; // 다음 이닝으로
					out = 0; // 아웃 카운트 초기화
					ground = new boolean[4]; // 그라운드 상황 초기화
				}
			}
			else if(hit == 4) { // 홈런
				score++;
				for(int i=0; i<4; i++) {
					if(ground[i]) {
						score++;
						ground[i] = false;
					}
				}
			}
			else { // 안타, 2루타, 3루타
				score += move(hit);
				ground[hit] = true;
			}
			if (++curPlayer == 9) curPlayer = 0;
		}
		max = Math.max(max, score);
	}
	
	static int move(int type) {
		int sum = 0;
		boolean[] moveGround = new boolean[4];
		
		for(int i=0; i<4; i++) {
			if(ground[i] && (i+type)>=4) {
				sum++; // 홈에 도착하면 점수 증가
				ground[i] = false;
			}
			else if(ground[i] && (i+type)<4 ) {
				moveGround[(i+type)%4] = ground[i]; // 홈 외 다른 곳에 도착하면 선수 이동
			}
		}
		ground = moveGround;
		return sum;
	}
}