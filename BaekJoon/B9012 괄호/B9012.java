package M04_2;

import java.io.*;
import java.util.*;

public class B9012 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		next : for(int t=1; t<=T; t++) {
			ArrayDeque<Character> stack = new ArrayDeque<>();
			
			String str = br.readLine();
			for(int i=0; i<str.length(); i++) {
				char input = str.charAt(i);
				if(input == '(') stack.push(input);
				else {
					if(!stack.isEmpty()) {
						stack.pop();
					}
					else {
						sb.append("NO").append("\n");
						continue next;
					}
				}
			}
			if(stack.isEmpty()) sb.append("YES").append("\n");
			else sb.append("NO").append("\n");
		}
		System.out.println(sb);
		br.close();
	}

}
