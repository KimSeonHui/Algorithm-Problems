package M03_5;

import java.io.*;
import java.util.*;

public class B12865 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] weights = new int[N+1];
		int[] profits = new int[N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			weights[i] = Integer.parseInt(st.nextToken());
			profits[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[N+1][K+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=K; j++) {
				if(weights[i] > j) dp[i][j] = dp[i-1][j];
				else dp[i][j] = Math.max(dp[i-1][j], profits[i]+dp[i-1][j-weights[i]]);
			}
		}
		System.out.println(dp[N][K]);
		br.close();
	}
}