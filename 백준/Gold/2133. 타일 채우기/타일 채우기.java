import java.io.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1]; 
		if(N==1) {
			System.out.println(0);
			System.exit(0);
		}
		else {
			dp[1] = 0;
			dp[2] = 3;
			for(int i=3; i<=N; i++) {
                if(i%2==0) {
                    dp[i] = dp[i-2] * dp[2] + 2;

                    for(int j=0; j<=(i-4)/2; j++) {
                        dp[i] += dp[2*j] *2;
                    }
                }
				
			}
		}
		System.out.println(dp[N]);
		br.close();
	}
}