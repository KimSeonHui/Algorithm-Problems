package M03_2;

import java.io.*;
import java.util.*;

public class B1927 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		int sec=0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		while(sec < N) {
			int input = Integer.parseInt(br.readLine());
			
			if(input==0) {
				if(!pq.isEmpty()) sb.append(pq.poll()).append("\n");
				else sb.append(0).append("\n");
			}
			else {
				pq.offer(input);
			}
			sec++;
		}
		System.out.println(sb.toString());
		br.close();
	}
}