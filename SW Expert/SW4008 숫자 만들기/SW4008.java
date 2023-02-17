import java.io.*;
import java.util.*;

public class SW4008 {
    static int[] oper;
	static int[] nums;
	static int N;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
	
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			oper = new int[4];
			nums = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<4; i++) {
				oper[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			perm(0, nums[0], 1);
			sb.append("#").append(tc).append(" ").append(max-min).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
	
	static void perm(int cnt, int sum, int index) {
		if (cnt == N - 1) {
			min = Math.min(min, sum);
			max = Math.max(max, sum);
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (oper[i] <= 0) continue;
			oper[i]--;
			if (i == 0) { // 더하기
				perm(cnt+1, sum+nums[index], index+1);
			} else if (i == 1) { // 빼기
				perm(cnt+1, sum-nums[index], index+1);
			} else if (i == 2) { // 곱하기
				perm(cnt+1, sum*nums[index], index+1);
			} else { // 나누기
				perm(cnt+1, sum/nums[index], index+1);
			}
			oper[i]++;
		}
	}
}
