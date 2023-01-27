package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B4153 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int max = 0;
		int sum = 0;		
		
		while(a != 0 && b != 0 && c != 0) {
			if(b < a && c < a) {
				max = a*a;
				sum = b*b + c*c;
			}
			else if(a < b && c < b) {
				max = b*b;
				sum = a*a + c*c;
			}
			else if(a < c && b < c) {
				max = c*c;
				sum = a*a + b*b;
			}
			
			System.out.println((sum == max) ? "right" : "wrong");
			
			st = new StringTokenizer(br.readLine()); 
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
		}
	}

}
