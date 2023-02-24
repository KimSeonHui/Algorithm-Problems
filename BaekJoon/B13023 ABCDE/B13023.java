package M02_4;

import java.io.*;
import java.util.*;

public class B13023 {
	static int N, M;
	static List<Integer>[] g;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		g = new List[N];
		
		for(int i=0; i<N; i++) g[i] = new ArrayList<>();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			g[from].add(to);
			g[to].add(from);
		}
		
		int ans = 0;
		for(int i=0; i<N; i++) {
			if(dfs(i, new boolean[N], 1)) {
				ans=1;
				break;
			}
		}
		System.out.println(ans);
		br.close();
	}
	
	static boolean dfs(int cur, boolean[] v, int cnt) {
		v[cur] = true;
		if(cnt == 5) return true;
		
		for(int j : g[cur]) {
			if(!v[j]) {
				if(dfs(j, v, cnt+1)) return true;
				v[j] = false;
			}
		}
		return false;
	}
}
