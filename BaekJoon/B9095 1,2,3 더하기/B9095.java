package M03_4;

import java.io.*;

public class B9095 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for(int t=0; t<T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			int[] dp = new int[n+1];
			if(n == 1) {
				sb.append(1).append("\n");
				continue;
			}
			else if(n == 2) {
				sb.append(2).append("\n");
				continue;
			}
			else if(n == 3) {
				sb.append(4).append("\n");
				continue;
			}
			else {
				dp[1] = 1;
				dp[2] = 2;
				dp[3] = 4;
				
				for(int i=4; i<=n; i++) {
					dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
				}
				sb.append(dp[n]).append("\n");
			}
		}
		System.out.println(sb);
		br.close();
	}
}