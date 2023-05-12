import java.io.*;
import java.util.*;

public class Main {
    static int C, N;
    static int[][] input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        input = new int[N+1][2];
        int[] dp = new int[C+101];
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            input[i][0] = Integer.parseInt(st.nextToken()); // 홍보비
            input[i][1] = Integer.parseInt(st.nextToken()); // 얻는 고객 수
        }
        for(int i=0; i<C+101; i++) dp[i] = Integer.MAX_VALUE/2;
        
        dp[0] = 0;
        for(int i=1; i<=N; i++) {
            for(int c=input[i][1]; c<C+101; c++) { 
            	dp[c] =  Math.min(dp[c], dp[c-input[i][1]] + input[i][0]);
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int i=C; i<C+101; i++) {
        	min = Math.min(min, dp[i]);
        }
        
        System.out.println(min);
        br.close();
    }


}
