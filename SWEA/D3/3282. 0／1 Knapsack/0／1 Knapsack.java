import java.io.*;
import java.util.*;


public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine(), " ");

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] v = new int[N+1]; // 부피
            int[] c = new int[N+1]; // 가치

            for(int i=1; i<=N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                v[i] = Integer.parseInt(st.nextToken());
                c[i] = Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[N+1][K+1];
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=K; j++) {
                    if(j < v[i]) dp[i][j] = dp[i-1][j];
                    else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-v[i]] + c[i]);
                    }
                }
            }
            sb.append("#" + t + " " + dp[N][K] + "\n");
        }
        System.out.println(sb);
        br.close();
    }
}