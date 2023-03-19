package M03_4;

import java.io.*;

public class B10808 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		
		int[] alphabet = new int[26];
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			alphabet[ch-'a']++;
		}
		for(int i=0; i<26; i++) sb.append(alphabet[i]).append(" ");
		System.out.println(sb.toString());
		br.close();
	}
}
