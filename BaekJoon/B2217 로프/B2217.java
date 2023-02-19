package backjoon;

import java.io.*;
import java.util.*;

public class B2217 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] rope = new int[N];
		
		for(int i=0; i<N; i++) {
			rope[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(rope);
		
		int max = 0;
		int k=1;
		for(int i=N-1; i>=0; i--) {
			max = Math.max(rope[i]*k++, max);
		}
		System.out.println(max);
	}
}
