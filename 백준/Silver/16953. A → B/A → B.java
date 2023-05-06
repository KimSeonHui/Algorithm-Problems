import java.io.*;
import java.util.*;

public class Main {
	static int B;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		System.out.println(bfs(A));
		br.close();
	}
	
	static long bfs(int a) {
		ArrayDeque<long[]> q = new ArrayDeque<>();
		q.offer(new long[] {a, 0});
		
		while(!q.isEmpty()) {
			long[] cur = q.poll();
			
			if(cur[0] == B) return cur[1]+1;
			
			long[] move = {cur[0]*2, cur[0]*10+1};
			for(int d=0; d<2; d++) {
				if(move[d] <= B) q.offer(new long[] {move[d], cur[1]+1});
			}
		}
		return -1;
	}
}
