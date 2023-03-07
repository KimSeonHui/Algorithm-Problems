package M03_2;

import java.io.*;
import java.util.*;

public class B1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int minusCnt = 0;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)=='-') minusCnt++;
		}
		
		int[] sum = new int[minusCnt+1];
		int index=0;
		String num="";
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			
			if(ch !='-' && ch !='+') { // 숫자일 때
				if(ch=='0') {
					if(num.length()!=0) num += ch;
				}
				else {
					num += ch;
				}
			}
			else { // 연산자 일 때
				sum[index] += Integer.parseInt(num);
				num = "";
				if(ch == '-') index++;
			}
		}
		
		sum[index] += Integer.parseInt(num); // 마지막 숫자 더하기
		int ans = sum[0];
		for(int i=1; i<sum.length; i++) {
			ans -= sum[i];
		}
		System.out.println(ans);
		br.close();
	}
}