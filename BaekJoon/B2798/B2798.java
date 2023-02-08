package backjoon;

import java.io.*;
import java.util.*;

public class B2798 {
	static int N;
	static int M;
	static int min = 0;
	static int[] cards;
	static int[] combs;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cards = new int[N];
		combs = new int[N];
		min = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		comb(0,0);
		System.out.println(min);
	}
	
	static void comb(int cnt, int start) {
		if(cnt == 3) {
			// 합 계산
			int sum = 0;
			for(int i=0; i<3; i++) {
				sum += combs[i];
			}
			if(sum <= M) { // 3 카드의 합이 M보다 작거나 같으면 합 중에서 최소값 계산
				min = Math.max(sum, min);
			}
			return;
		}
		
		for(int i=start; i<N; i++) {
			combs[cnt] = cards[i];
			comb(cnt+1, i+1);
		}
	}
}
