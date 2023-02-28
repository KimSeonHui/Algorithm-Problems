package M02_05;

import java.io.*;
import java.util.*;

public class SW3124 {
	static int N;
	static int[][] edges;
	static int[] p;
	
	static void make() {
		p = new int[N+1];
		for(int i=1; i<=N; i++) p[i] = i;
	}
	
	static int find(int a) {
		if(a==p[a]) return a;
		return p[a] = find(p[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot==bRoot) return false;
		p[bRoot]=aRoot;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			edges = new int[E+1][3];
			
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				edges[i] = new int[] {from, to, weight};
			}
            
			Arrays.sort(edges, (o1, o2)-> Integer.compare(o1[2], o2[2]));
			make();
			long result = 0, cnt=0;
			for(int[] edge : edges) {
				if(union(edge[0], edge[1])) {
					result += edge[2];
					if(++cnt == N-1) break;
				}
			}
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
}
