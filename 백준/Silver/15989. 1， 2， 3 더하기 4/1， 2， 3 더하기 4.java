import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			if(N==1) sb.append(1).append("\n");
			else if(N==2) sb.append(2).append("\n");
			else if(N==3) sb.append(3).append("\n");
			else {
				int[][] dp = new int[N+1][4];
				dp[1][1] = 1;
				dp[2][1] = 1; dp[2][2] = 1;
				dp[3][1] = 1; dp[3][2] = 1; dp[3][3] = 1;
				
				for(int i=4; i<=N; i++) {
					dp[i][1] = dp[i-1][1];
					dp[i][2] = dp[i-2][1] + dp[i-2][2];
					dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
				}
				sb.append(dp[N][1] + dp[N][2] + dp[N][3]).append("\n");
			}
		}
		System.out.println(sb);
		br.close();
	}
}