package M03_4;

import java.io.*;

public class B1003 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			if(N==0) {
				sb.append(1).append(" ").append(0).append("\n");
				continue;
			}
			else if(N==1) {
				sb.append(0).append(" ").append(1).append("\n");
				continue;
			}
			else {
				int[][] dp = new int[N+1][2];
				dp[0][0] = 1;
				dp[0][1] = 0;
				dp[1][0] = 0;
				dp[1][1] = 1;
				
				for(int i=2; i<=N; i++) {
					dp[i][0] = dp[i-1][0] + dp[i-2][0];
					dp[i][1] = dp[i-1][1] + dp[i-2][1];
				}
				sb.append(dp[N][0]).append(" ").append(dp[N][1]).append("\n");
			}
		}
		System.out.println(sb);
		br.close();
	}
}
