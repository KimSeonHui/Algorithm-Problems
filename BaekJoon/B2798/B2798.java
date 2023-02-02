package backjoon;

import java.io.*;
import java.util.*;

public class B2798 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] cards = new int[N];
		int sum = 0;
		int min = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				for(int k=j+1; k<N; k++) {
					sum = cards[i] + cards[j] + cards[k];
					if(sum <= M) min = M-sum < M-min ? sum : min;
				}
			}
		}
		System.out.println(min);
	}

}
