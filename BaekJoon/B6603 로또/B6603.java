package M04_3;

import java.io.*;
import java.util.*;

public class B6603 {
	static int K;
	static int[] S;
	static int[] res;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = null;
		
		while(true) {
			st = new StringTokenizer(br.readLine(), " ");
			K = Integer.parseInt(st.nextToken());
			
			if(K==0) break;
			S = new int[K];
			for(int i=0; i<K; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}
			res = new int[6];
			comb(0, 0);
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	static void comb(int cnt, int start) {
		if(cnt == 6) {
			for(int val : res) sb.append(val).append(" ");
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<K; i++) {
			res[cnt] = S[i];
			comb(cnt+1, i+1);
		}
	}

}
