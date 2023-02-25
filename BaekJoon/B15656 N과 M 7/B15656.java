package M02_4;

import java.io.*;
import java.util.*;

public class B15656 {
	static StringBuilder sb;
	static int N, M;
	static int[] res, input;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		res = new int[M];
		input = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) input[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(input);
		perm(0);
		System.out.println(sb.toString());
	}
	
	static void perm(int cnt) {
		if(cnt == M) {
			for(int i=0; i<M; i++) sb.append(res[i]).append(" ");
			sb.append("\n");
			return;
		}
		for(int i=0; i<N; i++) {
			res[cnt] = input[i];
			perm(cnt+1);
		}
	}
}
