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
			else if(N==3) sb.append(4).append("\n");
			else {
				long[] dp = new long[N+1];
				dp[1] = 1;
				dp[2] = 2;
				dp[3] = 4;
				for(int i=4; i<=N; i++) {
					dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % 1000000009;
				}
				sb.append(dp[N] % 1000000009).append("\n");
			}
		}
		System.out.println(sb);
		br.close();
	}
}