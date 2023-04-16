package M04_4;

import java.io.*;

public class B9461 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			if(N<=3) {
				sb.append(1).append("\n");
				continue;
			}
			else if(N<=5) {
				sb.append(2).append("\n");
				continue;
			}
			else {
				long[] dp = new long[N+1];
				dp[1] = dp[2] = dp[3] = 1;
				dp[4] = dp[5] = 2;
				for(int i=6; i<=N; i++) {
					dp[i] = dp[i-1] + dp[i-5];
				}
				sb.append(dp[N]).append("\n");
			}
		}
		System.out.println(sb);
		br.close();
	}

}
