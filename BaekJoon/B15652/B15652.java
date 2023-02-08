package backjoon;

import java.io.*;
import java.util.*;

public class B15652 {
	static int N;
	static int M;
	static int[] nums;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[M];
		
		duplComb(0, 1);
		System.out.println(sb.toString());
	}
	
	static void duplComb(int cnt, int start) {
		if(cnt == M) {
			for(int i=0; i<M; i++) {
				sb.append(nums[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<=N; i++) {
			nums[cnt] = i;
			duplComb(cnt+1, i);
		}
	}
}
