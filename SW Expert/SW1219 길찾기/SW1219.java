package M02_4;

import java.io.*;
import java.util.*;

public class SW1219
{
    static boolean[] v;
	static int[][] mat;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for(int t=1; t<=10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int tc = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			v = new boolean[100];
			mat = new int[100][2];
			
			for(int i=0; i<100; i++) {
				for(int j=0; j<2; j++) mat[i][j] = -1;
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<E; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				if(mat[from][0] == -1) mat[from][0] = to;
				else mat[from][1] = to;
			}
			
			if(dfs(0)) sb.append("#").append(t).append(" ").append(1).append("\n");
			else sb.append("#").append(t).append(" ").append(0).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
    static boolean dfs(int i) {
		if(i==99) return true;
		
		v[i] = true;
		int cur = i;
		for(int j=0; j<2; j++) {
			cur = mat[i][j];
			if(cur !=-1 && !v[cur]) {
				if(dfs(cur)) return true;
			}
		}
		return false;
	}
}