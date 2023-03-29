package M03_5;

import java.io.*;
import java.util.*;

public class B10971 {
	static int[][] costs;
	static int[] res;
	static boolean[] v;
	static int N, minCost;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		costs = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				costs[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		res = new int[N];
		v = new boolean[N];
		minCost = Integer.MAX_VALUE;
		perm(0, 0);
		
		System.out.println(minCost);
		br.close();
	}

	static void perm(int cnt, int cost) {
		if(minCost < cost) return;
		if(cnt==N) {
			// 순열 완성
			if(costs[res[N-1]][res[0]] != 0) {
				minCost = Math.min(minCost, cost + costs[res[N-1]][res[0]]);
			}
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(v[i]) continue;
			
			v[i] = true;
			res[cnt] = i;
			if(cnt==0) perm(cnt+1, cost+costs[res[cnt]][i]);
			else if(cnt!=0 && costs[res[cnt-1]][i]!=0) perm(cnt+1, cost+costs[res[cnt-1]][i]);
			v[i] = false;
		}
	}
}