package M04_1;

import java.io.*;
import java.util.*;

public class B2458 {
	static final int INF = Integer.MAX_VALUE/2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] g = new int[N+1][N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			g[from][to] = 1;
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i!=j && g[i][j]==0) g[i][j] = INF; 
			}
		}
		
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					g[i][j] = Math.min(g[i][j], g[i][k]+g[k][j]);
				}
			}
		}
		
		int answer=0;
		for(int i=1; i<=N; i++) {
			int cnt=0;
			for(int j=1; j<=N; j++) {
				if(i!=j && g[i][j]!=INF) cnt++; 
				if(i!=j && g[j][i]!=INF) cnt++; 
			}
			if(cnt==N-1) answer++;
		}
		System.out.println(answer);
		br.close();
	}
}
