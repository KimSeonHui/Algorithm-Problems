package M02_4;

import java.io.*;
import java.util.*;

public class B15665 {
	static StringBuilder sb;
	static int[] res, input;
	static int N, M;
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
		br.close();
	}
	
	static void perm(int cnt) {
		if(cnt == M) {
			for(int i=0; i<M; i++) sb.append(res[i]).append(" ");
			sb.append("\n");
			return;
		}
		int checked = -1;
		for(int i=0; i<N; i++) {
			if(checked == input[i]) continue;
			res[cnt] = input[i];
			checked = input[i];
			perm(cnt+1);
		}
	}

}
