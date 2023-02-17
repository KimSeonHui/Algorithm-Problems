package backjoon;

import java.io.*;
import java.util.*;

public class B11047 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] coins = new int[N];
		
		for(int i=N-1; i>=0; i--) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		int sum=0, cnt=0, index = 0;
		while(sum < K) {
			if(coins[index] > K-sum) index++;
			if(sum+coins[index] <= K) {
				sum += coins[index];
				cnt++;
			}
			if(sum == K) break;
		}
		System.out.println(cnt);
	}
}
