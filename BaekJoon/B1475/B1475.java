package backjoon;

import java.io.*;

public class B1475 {
	static int[] nums = {1,1,1,1,1,1,1,1,1,1};
    static int cnt = 1;
    static int index = 0;
    
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     String str = br.readLine();

	     for(int i=0; i<str.length(); i++) {
	    	 index = str.charAt(i) - '0';
	    	 if(index != 9 && index != 6) {
	    		 if(nums[index] > 0) nums[index]--;
	    		 else  addSet();
	    	 }
	    	 else {
	    		 if(nums[9] > 0) nums[9]--;
	    		 else if(nums[6] > 0) nums[6]--;
	    		 else  addSet();
	    	 }
	     }
	     System.out.println(cnt);
	}
	
	public static void addSet() {
		cnt++;
		for(int i=0; i < nums.length; i++) {
			if(index != i) nums[i]++;
		}
	}
	

}
