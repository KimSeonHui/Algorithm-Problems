package M02_4;

import java.io.*;
import java.util.*;

public class SW1247
{
    static int N;
	static boolean[] v;
	static int[] res;
	
	static int[] company, home;
	static int[][] customer;
	static int min;
    
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			company = new int[]{r, c};
			
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			home = new int[]{r, c};
			
			customer = new int[N][2];
			for(int i=0; i<N; i++) {
				r = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				
				customer[i][0] = r;
				customer[i][1] = c;
			}
			
			min = Integer.MAX_VALUE;
			v = new boolean[N];
			res = new int[N];
			perm(0, company[0], company[1], 0);
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
    
	static void perm(int cnt, int r, int c, int dis) {
		if(dis > min) return;
		if(cnt == N) {
			dis += Math.abs(r-home[0]) + Math.abs(c-home[1]);
			min = Math.min(min, dis);
			return;
		}
		for(int i=0; i<N; i++) {
			if(v[i]) continue;
			v[i] = true;
			int newDis = dis + Math.abs(r-customer[i][0]) + Math.abs(c-customer[i][1]);
			perm(cnt+1, customer[i][0], customer[i][1], newDis);
			v[i] = false;
		}
	}
}