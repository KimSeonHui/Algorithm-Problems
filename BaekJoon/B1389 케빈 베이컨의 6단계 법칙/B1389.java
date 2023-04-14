package M04_3;

import java.io.*;
import java.util.*;

public class B1389 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		final int INF = Integer.MAX_VALUE/2;
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] g = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i==j) g[i][j] = 0;
				else g[i][j] = INF;
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			g[a][b] = 1;
			g[b][a] = 1;
		}
		
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					g[i][j] = Math.min(g[i][j], g[i][k]+g[k][j]);
				}
			}
		}
		
		int min = INF;
		int minNum = 0;
		for(int i=1; i<=N; i++) {
			int sum = 0;
			for(int j=1; j<=N; j++) sum += g[i][j];
			if(sum < min) {
				min = sum;
				minNum = i;
			}
		}
		
		System.out.println(minNum);
		br.close();
	}

}
