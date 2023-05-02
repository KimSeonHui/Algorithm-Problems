import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		
		int cnt = 0;
		ArrayDeque<Character> stack = new ArrayDeque<>();
		for(int i=0; i<S.length(); i++) {
			char ch = S.charAt(i);
			if(ch == '(') stack.push(ch);
			else {
				if(stack.isEmpty()) cnt++;
				else {
					char pop = stack.poll();
					if(pop != '(') cnt++;
				}
			}
		}
		System.out.println(cnt + stack.size());
		br.close();
	}
}