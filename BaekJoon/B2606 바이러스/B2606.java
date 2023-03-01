package M03_1;

import java.io.*;
import java.util.*;

public class B2606 {
	static int N, E, ans;
	static boolean[] v;
	static int[][] g;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		
		g = new int[101][101];
		for(int i=0; i<E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			g[from][to] = 1;
			g[to][from] = 1;
		}
		
		ans = 0;
		bfs(1);
		//dfs(1, new boolean[101]);
		System.out.println(ans);
	}
	
	static void dfs(int cur, boolean[] v) {
		v[cur] = true;
		
		for(int j=1; j<=100; j++) {
			if(!v[j] && g[cur][j]==1) {
				dfs(j, v);
				ans++;
			}
		}
	}
	
	static void bfs(int cur) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		v = new boolean[101];
		v[cur] = true;
		q.add(cur);
		
		while(!q.isEmpty()) {
			int pos = q.poll();
			
			for(int j=1; j<=100; j++) {
				if(!v[j] && g[pos][j]==1) {
					v[j] = true;
					q.add(j);
					ans++;
				}
			}
		}
	}
}
