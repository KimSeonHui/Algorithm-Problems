package M03_3;

import java.io.*;
import java.util.*;

public class B11724 {
	static List<Integer>[] g;
	static boolean[] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		g = new List[N+1];
		for(int i=0; i<=N; i++) {
			g[i] = new ArrayList<>();
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			g[from].add(to);
			g[to].add(from);
		}
		
		v = new boolean[N+1];
		int cnt = 0;
		for(int i=1; i<=N; i++) {
			if(!v[i]) {
				bfs(i);
				cnt++;
			}
		}
		
		System.out.println(cnt);
		br.close();
	}
	
	static void bfs(int num) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		v[num] = true;
		q.offer(num);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int vertex : g[cur]) {
				if(!v[vertex]) {
					v[vertex] = true;
					q.offer(vertex);
				}
			}
		}
	}

}
