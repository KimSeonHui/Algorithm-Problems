package backjoon;

import java.io.*;

public class B1436 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int start = 666;
		int cnt = 0;
		
		while(true) {
			if(isSeries(start)) cnt++;
			if(cnt == N) break;
			
			start++;
		}
		System.out.println(start);
	}
	
	public static boolean isSeries(int num) {
		int count = 0;
		
		while(num > 0 && count < 3) {
			if(num % 10 == 6) {
				count++;
			}
			else {
				count=0;
			}
			num = num/10;
		}
		
		return count == 3;
	}

}
