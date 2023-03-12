package M03_3;

import java.io.*;
import java.util.*;

public class B1535 {
	
	static int N, ans, joyToal;
	static int[] health, joys;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		health = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			health[i] = Integer.parseInt(st.nextToken());
		}
		
		joys = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			joys[i] = Integer.parseInt(st.nextToken());
			joyToal += joys[i];
		}
		
		subs(0, 100, 0); // cnt, health, joy
		System.out.println(ans);
		br.close();
	}

	static void subs(int cnt, int healthSum, int joySum) {
		if(healthSum <= 0) return;
		if(joySum == joyToal) {
			ans = joySum;
			return;
		}
		if(cnt == N) {
			ans = Math.max(ans, joySum);
			return;
		}
		
		subs(cnt+1, healthSum-health[cnt], joySum+joys[cnt]);
		subs(cnt+1, healthSum, joySum);
	}
}
