package backjoon;

import java.io.*;
import java.util.*;

public class B1629 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		System.out.println(cal(a, b, c));
	}

	static long cal(int a, int b, int c) {
		if(b == 1) return a%c;
		long val = cal(a, b/2, c);
		val = val * val % c;
		if(b%2 == 0) return val;
		else return val * a % c;
	}
}
