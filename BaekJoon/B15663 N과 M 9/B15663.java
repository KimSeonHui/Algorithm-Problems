package M02_4;

import java.io.*;
import java.util.*;

public class B15663 {
	static StringBuilder sb;
	static int[] res, input;
	static boolean[] v;
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		res = new int[M];
		input = new int[N];
		v = new boolean[N];
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
		int checked = -1;
		for(int i=0; i<N; i++) {
			if(v[i] || checked == input[i]) continue;
			v[i] = true;
			res[cnt] = input[i];
			checked = input[i];
			perm(cnt+1);
			v[i] = false;
		}
	}
}
