package M04_1;

import java.io.*;
import java.util.*;

public class B2042 {
	static long[] tree;
	static int N;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long[] nums = new long[N+1];
		tree = new long[N+1];
		for(int i=1; i<=N; i++) {
			nums[i] = Long.parseLong(br.readLine());
			update(i, nums[i]);
		}
		
		for(int i=0; i<M+K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int type = Integer.parseInt(st.nextToken());
			
			// update
			if(type==1) {
				int b = Integer.parseInt(st.nextToken());
				long c = Long.parseLong(st.nextToken());
				
				update(b, c-nums[b]);
				nums[b] = c;
			}
			//sum
			else {
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				sb.append(sum(b, c)).append("\n");
			}
		}
		System.out.println(sb);
	}
	
	static void update(int i, long diff) {
		while (i <= N) {
			tree[i] += diff;
			i += (i & -i);
		}
	}
	
	static long sum(int i, int j) {
		return sum(j)-sum(i-1);
	}
	
	static long sum(int i) {
		long ans = 0;
		while(i > 0) {
			ans += tree[i];
			i -= (i & -i);
		}
		return ans;
	}
}