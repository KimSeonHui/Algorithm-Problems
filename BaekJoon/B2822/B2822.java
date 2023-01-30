package backjoon;

import java.io.*;
import java.util.*;

public class B2822 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int sum = 0;
		int[] scores = new int[8];
		List<Integer> scores2 = new ArrayList<>();
		int[] index = new int[5];
		
		for(int i=0; i<8; i++) {
			int num = Integer.parseInt(br.readLine());
			scores[i] = num;
			scores2.add(num);
		}
		
		Arrays.sort(scores);
		
		for(int i=3; i<8; i++) {
			sum += scores[i];
			index[i-3] = scores2.indexOf(scores[i])+1;
		}
		sb.append(sum).append("\n");
		
		Arrays.sort(index);
		for(int i=0; i<5; i++) {
			sb.append(index[i]).append(" ");
		}
		
		System.out.println(sb.toString());
	}

}
