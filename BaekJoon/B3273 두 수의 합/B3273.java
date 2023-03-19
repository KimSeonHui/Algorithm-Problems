package M03_4;

import java.io.*;
import java.util.*;

public class B3273 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) nums[i] = Integer.parseInt(st.nextToken());
		
		int X = Integer.parseInt(br.readLine());
		
		int start=0, end=N-1, cnt=0;
		Arrays.sort(nums);
		while(start != end) {
			int sum = nums[start] + nums[end];
			if(sum == X) {
				cnt++;
				start++;
			}
			else if(sum > X) end--;
			else if(sum < X) start++;
		}
		System.out.println(cnt);
		br.close();
	}
}
