package M03_4;

import java.io.*;
import java.util.*;

public class B12852 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		if(N==1) {
			sb.append(0).append("\n");
			sb.append(1);
		}
		else if(N==2) {
			sb.append(1).append("\n");
			sb.append(2).append(" ").append(1);
		}
		else {
			Arrays.fill(dp, Integer.MAX_VALUE);
			
			dp[1] = 0;
			dp[2] = 1;
			dp[3] = 1;
			
			for(int i=4; i<=N; i++) {
				if(i%3==0) {
					dp[i] = Math.min(dp[i], dp[i/3]+1);
				}
				if(i%2==0) {
					dp[i] = Math.min(dp[i], dp[i/2]+1);
				}
				if(dp[i] >= dp[i-1]+1) {
					dp[i] = dp[i-1]+1;
				}
			}
			sb.append(dp[N]).append("\n");
			int cur = N;
			sb.append(cur).append(" ");
			int min = N;
			while(cur != 1) {
				min = cur;
				if(cur%3==0 && dp[cur/3] < dp[min]) {
					min = cur/3;
				}
				if(cur%2==0 && dp[cur/2] < dp[min]) {
					min = cur/2;
				}
				if(dp[cur-1] < dp[min]) {
					min = cur-1;
				}
				sb.append(min).append(" ");
				cur = min;
			}
		}
		System.out.println(sb);
		br.close();
	}
}