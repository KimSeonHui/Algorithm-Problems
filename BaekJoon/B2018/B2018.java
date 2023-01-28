package backjoon;

import java.io.*;

public class B2018 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		int sum = 0;
		
		for(int i=1; i<=N; i++) {
			sum = i;
			if(sum == N) cnt++;
			for(int j=i+1; j<=N; j++) {
				sum += j;
				if(sum == N) { // 자연수의 합이 N과 같을 때
					cnt++;
					break;
				}
				if(sum > N) break; // 자연수의 합이 N을 초과했을 때
			}
		}
		System.out.println(cnt);
	}
}
