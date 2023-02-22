package M02_4;
import java.io.*;
import java.util.*;

public class B4963 {
	static int[] dr = {-1,-1,0,1,1,1,0,-1}; //상 우상 우 우하 하 좌하 좌 좌상
	static int[] dc = {0,1,1,1,0,-1,-1,-1}; //상 우상 우 우하 하 좌하 좌 좌상
	static boolean[][] v;
	static int[][] map;
	static int R,C, cnt;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		while(R!=0 && C!=0) {
			map = new int[R][C];
			v = new boolean[R][C];
			
			for(int i=0; i<R; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<C; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			cnt = 0;
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(v[i][j] || map[i][j]==0) continue;
					bfs(i,j);
					cnt++;
				}
			}
			sb.append(cnt).append("\n");
			
			// 다음 입력 받기
			st = new StringTokenizer(br.readLine(), " ");
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
		}
		System.out.println(sb.toString());
		br.close();
	}
	
	static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		v[i][j] = true;
		q.add(new int[]{i,j});
		
		while(!q.isEmpty()) {
			int[] pos = q.poll();
			
			for(int d=0; d<8; d++) {
				int ni = pos[0] + dr[d];
				int nj = pos[1] + dc[d];
				
				if(0<=ni&&ni<R && 0<=nj&&nj<C && !v[ni][nj] && map[ni][nj]==1) {
					v[ni][nj] = true;
					q.add(new int[]{ni,nj});
				}
			}
		}
	}
}
