import java.io.*;
import java.util.*;

public class Main {
	static int[] dr = { -1, 0, 1, 0 }; // 상우하좌
	static int[] dc = { 0, 1, 0, -1 }; // 상우하좌
	static boolean[][][] isOpen; // 국경 연 나라 확인
	static boolean[][] v; // 연합 확인
	static int sum, unitedCnt; // 연합된 나라 인구수, 연합된 나라 수
	static List<int[]> uc; // 연합된 나라 좌표 저장

	static int[][] world;
	static int N, L, R;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		world = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				world[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 0;
		while (true) {
			if(!move()) break;
			cnt++;
		}
		System.out.println(cnt);
		br.close();
	}

	static boolean move() {
		v = new boolean[N][N];
		boolean isMove = false;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(v[i][j]) continue;
				uc = new ArrayList<>();
				sum=0; unitedCnt=1;
				if(bfs(i,j)) isMove = true;
			}
		}
		return isMove;
	}

	static boolean bfs(int i, int j) {
		// 연합 확인
		boolean isMove = false;
		Queue<int[]> q = new ArrayDeque<>();
		v[i][j] = true; // 연합 확인
		q.add(new int[] { i, j }); // BFS 탐색을 위해 queue에 저장
		uc.add(new int[] { i, j }); // 연합인 나라 좌표 저장
		sum += world[i][j]; // 연합 인구 저장

		while (!q.isEmpty()) {
			int[] pos = q.poll();

			for (int d = 0; d < 4; d++) {
				int ni = pos[0] + dr[d];
				int nj = pos[1] + dc[d];

				// 범위를 벗어나지 않고, 방문한 곳이 아니면
				if (0 <= ni && ni < N && 0 <= nj && nj < N && !v[ni][nj]) {
					int gap = Math.abs(world[pos[0]][pos[1]] - world[ni][nj]); //두 나라 인구 수 차 계산
					if (L <= gap && gap <= R) { // 인구이동 가능한 범위 안의 인구 수 차라면!
						isMove = true;
						v[ni][nj] = true;
						q.offer(new int[] { ni, nj });
						uc.add(new int[] {ni, nj});
						sum += world[ni][nj];
						unitedCnt++;
					}
				}
			}
		}
		
		// 연합 나라에 인구 이동
		int movePopul = sum / unitedCnt; // 연합의 인구수
		for (int k = 0; k < unitedCnt; k++) {
			int[] country = uc.get(k); // 연합 나라 좌표 가져오기
			world[country[0]][country[1]] = movePopul; // 연합된 각 나라에 연합의 인구수 만큼만 살기
		}
		return isMove;
	}
}
