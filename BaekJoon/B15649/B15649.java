package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15649 {
	static StringBuilder sb;
	static int N;
	static int M;
	static int[] nums;
	static boolean[] isUsed;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[M];
        isUsed = new boolean[N];
        
        permu(0);
        System.out.println(sb.toString());
	}
	 static void permu(int cnt) {
	        if(cnt == M) {
	            for(int i=0; i <M; i++) {
	                sb.append(nums[i]).append(" ");
	            }
	            sb.append("\n");
	            return;
	        }
	        
	        for(int i=0; i<N; i++) {
	            if(!isUsed[i]) {
	            	nums[cnt] = i+1;
	                isUsed[i] = true;
	                permu(cnt+1);
	                isUsed[i] = false;
	            }
	        }
	 }
}
