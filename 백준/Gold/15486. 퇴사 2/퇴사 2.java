import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int[][] info = new int[N][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			info[i][0] = Integer.parseInt(st.nextToken()); // 시간
			info[i][1] = Integer.parseInt(st.nextToken()); // 비용
		}
		
		int[] dp = new int[N+1];
		int curMax = 0;
		for(int i=0; i<N; i++) {
			int endDay = i + info[i][0];
			curMax = Math.max(curMax, dp[i]);
			dp[i] = curMax;
			if(endDay < N+1) {
				dp[endDay] = Math.max(dp[endDay], dp[i] + info[i][1]);
			}
		}
		System.out.println(Math.max(dp[N-1], dp[N]));
		br.close();
	}
}