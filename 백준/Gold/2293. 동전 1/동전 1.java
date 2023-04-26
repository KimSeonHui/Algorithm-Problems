import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] coins = new int[N+1];
		for(int i=1; i<=N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		int[][] dp = new int[N+1][K+1];
		for(int i=0; i<=N; i++) {
			for(int k=0; k<=K; k++) {
				if(k == 0) dp[i][k] = 1;
			}
		}
		for(int i=1; i<=N; i++) {
			for(int k=1; k<=K; k++) {
				if(coins[i] <= k) {
					dp[i][k] = dp[i-1][k] + dp[i][k-coins[i]];
				}
				else dp[i][k] = dp[i-1][k];
			}
		}
		
		System.out.println(dp[N][K]);
		br.close();
	}
}