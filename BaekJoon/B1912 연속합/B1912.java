package M03_5;

import java.io.*;
import java.util.*;

public class B1912 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		int[] dp = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = nums[0];
		int max = dp[0];
		for(int i=1; i<N; i++) {
			dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
			if(max < dp[i]) max = dp[i];
		}

		System.out.println(max);
		br.close();
	}
}
