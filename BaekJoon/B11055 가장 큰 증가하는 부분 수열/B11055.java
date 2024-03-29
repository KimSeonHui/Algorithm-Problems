package M04_3;

import java.io.*;
import java.util.*;

public class B11055 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int[] dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = arr[i];
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<i; j++) {
				if(arr[j] < arr[i] && dp[i] < dp[j]+arr[i]) {
					dp[i] = dp[j]+arr[i];
				}
			}
		}
		
		int max = dp[0];
		for(int i=1; i<N; i++) {
			if(max < dp[i]) max = dp[i];
		}
		System.out.println(max);
		br.close();
	}

}
