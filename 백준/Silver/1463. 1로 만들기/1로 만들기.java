import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1];
		for(int i=0; i<N+1; i++) dp[i] = Integer.MAX_VALUE;
		
		if(N == 1) {
			System.out.println(0);
			System.exit(0);
		}
		else if(N == 2) {
			System.out.println(1);
			System.exit(0);
		}
		else if(N == 2) {
			System.out.println(1);
			System.exit(0);
		}
		
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;
		
		for(int i=4; i<=N; i++) {
			if(i%3==0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
			if(i%2==0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
			if(i-1 >= 0)dp[i] = Math.min(dp[i], dp[i-1] + 1);
		}
		System.out.println(dp[N]);
		br.close();
	}
}