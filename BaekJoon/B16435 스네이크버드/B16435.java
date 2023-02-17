package backjoon;

import java.io.*;
import java.util.*;

public class B16435 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] f = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			f[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(f);
		for(int i=0; i<N; i++) {
			if(f[i] <= L) L +=1;
		}
		System.out.println(L);
	}
}
