package backjoon;

import java.io.*;

public class B1259 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		while(true) {
			String str = br.readLine();
			
			boolean isPalindrome = true;
			if(str.charAt(0) == '0') break;
			
			for(int i=0; i<str.length()/2; i++) {
				if(str.charAt(i) != str.charAt(str.length()-1-i)) {
					isPalindrome = false;
					sb.append("no").append("\n");
					break;
				}
			}
			if(isPalindrome) sb.append("yes").append("\n");
		}
		System.out.println(sb.toString());
	}
}
