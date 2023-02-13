package backjoon;

import java.io.*;
import java.util.*;

public class B1158 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayDeque<Integer> q = new ArrayDeque<>();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=N; i++) {
			q.offer(i);
		}
		
		sb.append("<");
		int cnt = 1;
		while(!q.isEmpty()) {
			if(cnt == K) {
				if(q.size() == 1) sb.append(q.poll());
				else sb.append(q.poll()).append(", ");
				cnt = 1;
			}
			else {
				q.offer(q.poll());
				cnt++;
			}
		}
		sb.append(">");
		System.out.println(sb.toString());

	}

}
