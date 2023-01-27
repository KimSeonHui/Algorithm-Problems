package backjoon;

import java.io.*;
import java.util.*;

public class B1547 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int M = Integer.parseInt(br.readLine());
		List<Integer> cups = Arrays.asList(1,2,3);
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			int idxX = cups.indexOf(X);
			int idxY = cups.indexOf(Y);
			
			cups.set(idxX, Y);
			cups.set(idxY, X);
		}
		System.out.println(cups.get(0));
	}

}
