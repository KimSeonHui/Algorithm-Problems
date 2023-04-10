package M04_3;

import java.io.*;
import java.util.*;

public class B1929 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		for(int i=M; i<=N; i++) {
			if(isPrime(i)) sb.append(i).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	static boolean isPrime(int num) {
        if(num==1) return false;
		for(int i=2; i<=Math.sqrt(num); i++) {
			if(num%i==0) return false;
		}
		return true;
	}
}
