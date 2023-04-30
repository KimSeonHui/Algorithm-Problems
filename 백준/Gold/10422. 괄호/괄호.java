import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			long[] dp = new long[N+1]; // 카탈란 수 :: 괄호의 쌍의 개수가 i일때 올바른 괄호 문자열의 개수 
			dp[0] = 1;
			for(int i=0; i<N; i++) { // n
				for(int j=0; j<=i; j++) {
					dp[i+1] += dp[j]*dp[i-j];
                    dp[i+1] %= 1000000007;
				}
			}
			
			if(N % 2 ==0) {
				sb.append(dp[N/2]).append("\n");
			}
			else sb.append(0).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}