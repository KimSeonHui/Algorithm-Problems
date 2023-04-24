package M04_5;

import java.io.*;

public class B11057 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[N+1][10];
		
		// 초기값 
		for(int j=0; j<10; j++) {
			dp[0][j] = 1;
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=0; j<10; j++) {
				for(int k=j; k<10; k++) {
					dp[i][j] += dp[i-1][k] % 10007;
				}
			}
		}
		System.out.println(dp[N][0] % 10007);
		br.close();
	}
}
