package backjoon;

import java.io.*;

public class B1436 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int start = 666;
		int cnt = 0;
		
		while(true) {
			String num = Integer.toString(start);
			if(num.contains("666")) {
				cnt++;
				if(cnt == N) break;
			}
			start++;
		}
		System.out.println(start);
	}

}
