package backjoon;

import java.io.*;
import java.util.*;

public class B2961 {
	static int N;
	static int[][] flavors;
	static boolean[] v;
	static int min=1000000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		flavors = new int[N][2];
		v = new boolean[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			flavors[i][0] = Integer.parseInt(st.nextToken()); // 신맛
			flavors[i][1] = Integer.parseInt(st.nextToken()); // 쓴맛
		}
		

		subset(0, 1, 0);
		System.out.println(min);
	}
	static void subset(int cnt, int f1, int f2) {
		if(cnt == N) {
            if(f1 == 1 && f2 == 0) return; // 공집합일 때(아무것도 선택 안 됐을 때) 처리
			min = Math.min(min, Math.abs(f1-f2));
			return;
		}
		
		v[cnt] = true;
		subset(cnt+1, f1*flavors[cnt][0], f2 +flavors[cnt][1]);
		v[cnt] = false;
		subset(cnt+1, f1, f2);
	}

}
