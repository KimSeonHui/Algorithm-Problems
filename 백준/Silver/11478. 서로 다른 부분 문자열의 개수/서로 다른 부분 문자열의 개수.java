import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		
		Set<String> set = new HashSet();
		int start = 0;
		while(start < S.length()) {
			int end = start;
			String str = "";
			while(end < S.length()) {
				str += S.charAt(end);
				set.add(str);
				end++;
			}
			start++;
		}
		System.out.println(set.size());
		br.close();
	}

}
