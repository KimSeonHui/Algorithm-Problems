package backjoon;

import java.io.*;
import java.util.*;

public class B11286 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> 
			{
				int r = Integer.compare(Math.abs(o1), Math.abs(o2));
				if(r == 0) r = Integer.compare(o1, o2);
				return r;
			}
		);
		
		for(int i=0; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x == 0) {
				if(!q.isEmpty()) {
					sb.append(q.poll()).append("\n");
				}
				else sb.append(0).append("\n");
			}
			else {
				q.offer(x);
			}
		}
		System.out.println(sb.toString());
	}
}
