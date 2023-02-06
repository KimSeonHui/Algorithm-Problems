package backjoon;

import java.io.*;

public class B11729 {
	static StringBuffer sb = new StringBuffer();
	static int count = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		hanoi(n,1,2,3);
		System.out.println(count);
		System.out.println(sb.toString());
	}
	static void hanoi(int n, int from, int mid, int to) {
		if(n == 0) return;
		
		count++;
		hanoi(n-1, from, to, mid);
		sb.append(from).append(" ").append(to).append("\n");
		hanoi(n-1, mid, from, to);
	}
}
