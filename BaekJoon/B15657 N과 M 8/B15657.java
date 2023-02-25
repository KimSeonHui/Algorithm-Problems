package M02_4;

import java.io.*;
import java.util.*;

public class B15657 {
	static StringBuilder sb;
	static int N, M;
	static int[] input, res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		input = new int[N];
		res = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) input[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(input);
		comb(0, 0);
		System.out.println(sb.toString());
	}
	
	static void comb(int cnt, int start) {
		if(cnt == M) {
			for(int i=0; i<M; i++) sb.append(res[i]).append(" ");
			sb.append("\n");
			return;
		}
		for(int i=start; i<N; i++) {
			res[cnt] = input[i];
			comb(cnt+1, i);
		}
	}
}
