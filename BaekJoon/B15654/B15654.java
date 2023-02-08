package backjoon;

import java.io.*;
import java.util.*;

public class B15654 {
	static int N;
	static int M;
	static int[] nums;
	static int[] answer;
	static boolean[] isUsed;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		answer = new int[M];
		isUsed = new boolean[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		perm(0);
		System.out.println(sb.toString());
	}
	
	static void perm(int cnt) {
		if(cnt == M) {
			for(int i=0; i<M; i++) {
				sb.append(answer[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(isUsed[i]) continue;
			
			isUsed[i] = true;
			answer[cnt] = nums[i];
			perm(cnt+1);
			isUsed[i] =false;
		}
	}
}
