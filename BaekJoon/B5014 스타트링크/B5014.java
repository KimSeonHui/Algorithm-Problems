package M04_3;

import java.io.*;
import java.util.*;

public class B5014 {
	static int F, S, G, U, D;
	static boolean[] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		F = Integer.parseInt(st.nextToken()); // 총 높이
		S = Integer.parseInt(st.nextToken()); // 강호 층
		G = Integer.parseInt(st.nextToken()); // 스타트링크 층
		U = Integer.parseInt(st.nextToken()); // 위로 U만큼 이동
		D = Integer.parseInt(st.nextToken()); // 아래로 D만큼 이동
		
		v = new boolean[F+1];
		int min = F+1;
		min = Math.min(min, bfs(S));
		System.out.println((min != -1 ? min : "use the stairs"));
		br.close();
	}
	
	static int bfs(int num) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		v[num] = true;
		q.offer(new int[] {num, 0});
		
		int[] move = {+U, -D};
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			if(cur[0] == G) return cur[1];
			
			for(int d=0; d<2; d++) {
				int next = cur[0] + move[d];
				
				if(0<next && next<=F && !v[next]) {
					v[next] = true;
					q.offer(new int[] {next, cur[1]+1});
				}
			}
		}
		return -1;
	}
}