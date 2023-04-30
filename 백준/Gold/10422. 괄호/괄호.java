import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			long[] dp = new long[N+1]; // 문자열의 길이가 i일때 올바른 괄호 문자열의 개수 
			dp[0] = 1;
			if(N >=2) {
				dp[2] = 1;
				for(int i=2; i<=N/2; i++) {
					for(int j=0; j<=i-1; j++) {
						dp[i*2] += dp[j*2]*dp[(i-1-j)*2];
						dp[i*2] %= 1000000007;
					}
				}
			}
			sb.append(dp[N]).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}