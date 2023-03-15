package M03_3;

import java.io.*;
import java.util.*;

public class B11724 {
	static int[] p;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int cnt = N;
		
		makeSet();
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			if(union(from, to)) {
				cnt--;
			}
		}
		
		System.out.println(cnt);
		br.close();
	}
	
	static void makeSet() {
		p = new int[N+1];
		for(int i=1; i<=N; i++) p[i] = i;
	}
	
	static int find(int a) {
		if(a == p[a]) return a;
		return p[a] = find(p[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		p[bRoot] = aRoot;
		
		return true;
	}
}
