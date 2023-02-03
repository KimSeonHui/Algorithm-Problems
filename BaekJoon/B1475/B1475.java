package backjoon;

import java.io.*;

public class B1475 {
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     String str = br.readLine();
	     int[] nums = new int[9];
		 int cnt = 0;

	     for(int i=0; i<str.length(); i++) {
	    	 int index = str.charAt(i) - '0';
	    	 if(index == 9) nums[6]++;
	    	 else nums[index]++;
	     }
	     
	     nums[6] = (nums[6] % 2 == 0) ? nums[6]/2 : nums[6]/2+1;
	     for(int num : nums) {
	    	 cnt = Math.max(cnt, num);
	     }
	     
	     System.out.println(cnt);
	}
}
