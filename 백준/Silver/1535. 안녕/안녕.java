import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] health = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=1; i<=N; i++) {
			health[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] joy = new int[N+1];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=1; i<=N; i++) {
			joy[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[N+1][101];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=100; j++) {
				if(j - health[i] <= 0) {
					dp[i][j] = dp[i-1][j];
				}
				else dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-health[i]] + joy[i]);
			}
		}
		
		int max = 0;
		for(int i=1; i<101; i++) {
			max = Math.max(max, dp[N][i]);
		}
		
		System.out.println(max);
		br.close();
	}
}