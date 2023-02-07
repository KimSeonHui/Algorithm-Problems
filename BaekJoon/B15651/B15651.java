package backjoon;

import java.io.*;
import java.util.*;

public class B15651 {
	static int N;
	static int M;
	static int[] nums;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[M];
		
		duplPerm(0);
		System.out.println(sb.toString());
	}
	
	static void duplPerm(int cnt) {
		if(cnt == M) {
			for(int i=0; i<M; i++) {
                sb.append(nums[i]).append(" ");
            }
            sb.append("\n");
            return;
		}
		for(int i=0; i<N; i++) {
			nums[cnt] = i+1;
			duplPerm(cnt+1);
		}
	}
}
