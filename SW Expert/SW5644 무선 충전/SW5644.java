package M02_4;

import java.io.*;
import java.util.*;

class BC {
	int x;
	int y;
	int range;
	int power;

	BC(int x, int y, int range, int power) {
		this.x = x;
		this.y = y;
		this.range = range;
		this.power = power;
	}
}

public class SW5644 {
	static int[] dx = { 0, 0, 1, 0, -1 }; // 이동 x, 상, 우, 하, 좌
	static int[] dy = { 0, -1, 0, 1, 0 }; // 이동 x, 상, 우, 하, 좌

	static int[] moveA, moveB, posA, posB;
	static BC[] bcs;
	static int totalPower;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/input_sw5644.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());

			moveA = new int[M];
			moveB = new int[M];
			posA = new int[]{ 1, 1 };  posB = new int[]{ 10, 10 };
			
			// A 이동 경로 저장
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++) {
				moveA[i] = Integer.parseInt(st.nextToken());
			}

			// B 이동 경로 저장
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++) {
				moveB[i] = Integer.parseInt(st.nextToken());
			}

			// BC 정보 저장
			bcs = new BC[A];
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int range = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				bcs[i] = new BC(x, y, range, p);
			}

			// 동작
			int sec = 0;
			totalPower = 0;
			while (sec < M) {
				// 1. 충전
				charge();
				
				// 2. 이동
				move(sec);
				sec++;
			}
			charge(); // 마지막 위치에서  충전 한 번 더!
			sb.append("#").append(t).append(" ").append(totalPower).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}

	static void charge() {
		int max = 0;
		for(int a=0; a<bcs.length; a++) {
			for(int b=0; b<bcs.length; b++) {
				int sum = 0;
				
				//A와 bcs[a]의 거리 구하기
				int disA = Math.abs(posA[0] - bcs[a].x) + Math.abs(posA[1] - bcs[a].y);
				int powerA = disA<=bcs[a].range? bcs[a].power : 0;
				
				//B와 bcs[b]의 거리 구하기
				int disB = Math.abs(posB[0] - bcs[b].x) + Math.abs(posB[1] - bcs[b].y);
				int powerB = disB<=bcs[b].range? bcs[b].power : 0;
				
				if(a != b) sum = powerA + powerB;
				else if(a==b) sum = Math.max(powerA, powerB); // BC가 같을 때
				max = Math.max(max, sum);
			}
		}
		totalPower += max;
	}

	static void move(int sec) {
		// A 움직이기
		posA[0] += dx[moveA[sec]];
		posA[1] += dy[moveA[sec]];

		// B 움직이기
		posB[0] += dx[moveB[sec]];
		posB[1] += dy[moveB[sec]];
	}
}
