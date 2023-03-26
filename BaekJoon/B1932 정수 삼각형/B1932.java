package M03_5;

import java.io.*;
import java.util.*;

public class B1932 {
	static int N;
	static int[][] map, dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<=i; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(i==N-1) dp[i][j] = map[i][j];
			}
			if(i != N-1) Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		
		System.out.println(find(0,0));
		
		br.close();
	}
	
	static int find(int depth, int index) {
		if(depth == N-1) return map[depth][index];
		
		if(dp[depth][index] == Integer.MAX_VALUE) {
			dp[depth][index] = Math.max(find(depth+1, index), find(depth+1, index+1)) + map[depth][index];
		}
		return dp[depth][index];
	}
}
