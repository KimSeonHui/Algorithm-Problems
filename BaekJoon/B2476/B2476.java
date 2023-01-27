package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2476 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int maxMoney = 0;
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] dice = new int[7];
			int maxNum = 0;
			int money = 0;
			
			for(int j=0; j<3; j++) {
				dice[Integer.parseInt(st.nextToken())]++;
			}
			
			for(int j=1; j<=6; j++) {
				if(dice[j] == 3) {
					money = 10000 + j*1000;
					maxMoney = Math.max(maxMoney, money);
				}
				else if(dice[j] == 2) {
					money = 1000 + j*100;
					maxMoney = Math.max(maxMoney, money);
				}
				else if(dice[j] == 1){
					maxNum = Math.max(maxNum, j);
				}
			}
			
			if(maxNum != 0) {
				money = maxNum*100;
				maxMoney = Math.max(maxMoney, money);
			}
		}
		System.out.println(maxMoney);
	}

}
