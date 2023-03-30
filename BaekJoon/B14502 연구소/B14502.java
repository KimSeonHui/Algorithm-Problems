package M03_5;

import java.io.*;
import java.util.*;

public class B14502 {
	static int[] dr = {-1,0,1,0}; // 상우하좌
	static int[] dc = {0,1,0,-1}; // 상우하좌
	
	static int[] res;
	static int N, M, maxSafeArea;
	static int[][] map, temp;
	static List<int[]> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		temp = new int[N][M];
		list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==0) list.add(new int[] {i,j});
			}
		}
		
		// 1.벽을 놓을 위치 정하기 - 조합
		res = new int[3];
		maxSafeArea = Integer.MIN_VALUE;
		solution(0,0);
		
		System.out.println(maxSafeArea);
		br.close();
	}
	
	static void solution(int cnt, int start) {
		if(cnt == 3) {
			//temp 초기화
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) temp[i][j] = map[i][j];
			}
			
			// 2. 정한 위치에 벽 놓기
			for(int i=0; i<3; i++) {
				int[] pos = list.get(res[i]);
				int wr = pos[0], wc = pos[1];
				temp[wr][wc] = 1;
			}
			
			// 3. 바이러스 확산 - bfs
			spread();
			
			
			// 4. 안전 영역 크기 계산
			maxSafeArea = Math.max(maxSafeArea, calSafeArea());
			return;
		}
		
		for(int i=start; i<list.size(); i++) {
			res[cnt] = i;
			solution(cnt+1, i+1);
		}
	}
	
	static void spread() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(temp[i][j]==2) bfs(i,j);
			}
		}
	}
	
	static void bfs(int r, int c) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {r, c});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int d=0; d<4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(0<=nr&&nr<N && 0<=nc&&nc<M && temp[nr][nc]==0) {
					temp[nr][nc] = 2;
					q.offer(new int[] {nr,nc});
				}
			}
		}
	}
	
	static int calSafeArea() { // 안전 영역 크기 계산 - 0인 위치 개수 세기
		int area = 0;
		for(int[] t : temp) {
			for(int val : t) if(val==0) area++;
		}
		return area;
	}
}