package M02_4;

import java.io.*;
import java.util.*;

public class B1697 {
	static int N, K, sec;
	static boolean[] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		v = new boolean[100001];
		
		sec=0;
		bfs(N);
		System.out.println(sec);
		br.close();
	}
	
	static void bfs(int n) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		v[n] = true;
		q.add(n);
		
		int pos = 0, size=0;
		while(!q.isEmpty()) {
			size = q.size();
			
			while(size > 0) {
				pos = q.poll();
				if(pos == K) return;
				
				//2x
				int newN = pos*2;
				if(0<=newN&&newN<=100000 && !v[newN]) {
					v[newN] = true;
					q.offer(newN);
				}
				
				//x-1
				newN = pos-1;
				if(0<=newN&&newN<=100000 && !v[newN]) {
					v[newN] = true;
					q.offer(newN);
				}
				
				//x+1
				newN = pos+1;
				if(0<=newN&&newN<=100000 && !v[newN]) {
					v[newN] = true;
					q.offer(newN);
				}
				size--;
			}
			sec++;
		}
	}
}
