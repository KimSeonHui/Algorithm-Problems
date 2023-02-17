package backjoon;

import java.io.*;

public class B3040 {
	static int[] nums;
	static int[] ans;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		nums = new int[9];
		ans = new int[7];
		
		for(int i=0; i<9; i++) nums[i] = Integer.parseInt(br.readLine());
		comb(0,0,0);
		System.out.println(sb.toString());
	}
	
	static void comb(int cnt, int start, int sum) {
		if(sum > 100) return;
		if(cnt == 7) {
			if(sum == 100) for(int n : ans) sb.append(n).append("\n");
			return;
		}
		
		for(int i=start; i<9; i++) {
			ans[cnt] = nums[i];
			comb(cnt+1, i+1, sum+ans[cnt]);
		}
	}
}
