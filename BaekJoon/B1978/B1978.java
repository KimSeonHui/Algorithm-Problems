package backjoon;

import java.io.*;
import java.util.StringTokenizer;

public class B1978 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cnt = 0;
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(isPrime(num)) cnt++;
		}
		System.out.println(cnt);
	}

	public static boolean isPrime(int num) {
		if(num == 1) return false;
		
		for(int i=2; i*i<=num; i++) {
			for(int j=i*i; j <=num; j += i) {
				if(num % j == 0) return false;
			}
		}
		return true;
	}
}
