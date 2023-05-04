import java.io.*;
import java.util.*;

public class Main {
	static int N, min, max;
	static int[] nums, opers;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		opers = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			opers[i] = Integer.parseInt(st.nextToken());
		}
		
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		perm(0, nums[0]);
		sb.append(max).append("\n").append(min);
		System.out.println(sb);
		br.close();
	}
	
	static void perm(int cnt, int res) {
		if(cnt == N-1) {
			min = Math.min(min, res);
			max = Math.max(max, res);
			
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(opers[i] == 0) continue;
			
			opers[i]--; // 선택
			if(i==0) perm(cnt+1, res+nums[cnt+1]); // 덧셈
			else if(i==1) perm(cnt+1, res-nums[cnt+1]); // 뺄셈
			else if(i==2) perm(cnt+1, res*nums[cnt+1]); // 곱셈
			else perm(cnt+1, res/nums[cnt+1]); // 나눗셈
			opers[i]++; // 선택 복구
		}
	}
}
