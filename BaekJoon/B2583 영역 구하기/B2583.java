package M04_1;

import java.io.*;
import java.util.*;

public class B2583 {
	static int[] dr = { -1, 0, 1, 0 }; // 상우하좌
	static int[] dc = { 0, 1, 0, -1 }; // 상우하좌

	static int[][] map;
	static boolean[][] v;
	static int X, Y, K, cnt;
	static List<Integer> width;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[Y][X];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int lx = Integer.parseInt(st.nextToken()); // 좌하 x
			int ly = Integer.parseInt(st.nextToken()); // 좌하 y
			int rx = Integer.parseInt(st.nextToken()); // 우상 x
			int ry = Integer.parseInt(st.nextToken()); // 우상 y

			for (int y=ly; y<ry; y++) {
				for (int x=lx; x<rx; x++) {
					map[y][x] = 1; // 직사각형 그리기
				}
			}
		}
		
		width = new ArrayList<>(); // 남은 공간 넓이 저장
		v = new boolean[Y][X];
		for(int i=0; i<Y; i++) {
			for(int j=0; j<X; j++) {
				if(!v[i][j] && map[i][j]==0) { // 방문하지 않았고 직사각형이 아닌 공간이면
					bfs(i, j);
					cnt++;
				}
			}
		}
		
		Collections.sort(width); // 넓이 오름차순 정렬
		sb.append(cnt).append("\n");
		for(int w : width) sb.append(w).append(" ");
		System.out.println(sb);
		br.close();
	}
	
	static void bfs(int r, int c) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		v[r][c] = true;
		q.offer(new int[] {r,c});
		
		int size = 1;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int d=0; d<4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				// 배열 범위 안에 있고 방문 하지 않았고 직사각형이 아닌 공간이면
				if(0<=nr&&nr<Y && 0<=nc&&nc<X && !v[nr][nc] && map[nr][nc]==0) {
					v[nr][nc] = true;
					q.offer(new int[] {nr, nc});
					size++;
				}
			}
		}
		width.add(size);
	}

}
