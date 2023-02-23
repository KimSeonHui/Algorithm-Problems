package M02_4;

import java.io.*;
import java.util.*;

public class B1260 {
	static int N;
	static List<Integer>[] g;
	static boolean[] v;
	static StringBuilder sb;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		g = new List[N+1];
		for(int i=1; i<=N; i++) g[i] = new ArrayList<>();
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			g[from].add(to);
			g[to].add(from);
			Collections.sort(g[from]);
			Collections.sort(g[to]);
		}
		
		v = new boolean[N+1];
		dfs(start);
		
		sb.append("\n");
		v = new boolean[N+1];
		bfs(start);
		System.out.println(sb.toString());
	}
	
	static void dfs(int i) {
		v[i] = true;
		sb.append(i).append(" ");
		for(int j : g[i]) {
			if(!v[j]) {
				dfs(j);
			}
		}
	}
	
	static void bfs(int i) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		v[i] = true;
		q.add(i);
		
		while(!q.isEmpty()) {
			i = q.poll();
			sb.append(i).append(" ");
			for(int j : g[i]) {
				if(!v[j]) {
					v[j] = true;
					q.add(j);
				}
			}
		}
	}

}
