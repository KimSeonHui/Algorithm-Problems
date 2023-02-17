package backjoon;

import java.io.*;

public class B2839 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int sum = 0, cnt = 0;
		if (N % 5 == 0) cnt = N / 5;
		else {
			while (sum < N) {
				sum += 3;
				cnt++;
				if((N-sum)%5==0) {
					cnt += (N-sum)/5;
					break;
				}
				if(N-sum < 3) {
					cnt=-1;
					break;
				}
			}
		}
		System.out.println(cnt);
	}
}
