package backjoon;

import java.io.*;
import java.util.*;

public class B1547 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(br.readLine());
		boolean[] cups = {false, true, false, false};
		
		for(int i = 1; i <= M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			
			boolean temp = cups[X];
			cups[X] = cups[Y];
			cups[Y] = temp;
			
		}
		for(int i =1; i <=3; i++) {
			if(cups[i]) System.out.println(i);
		}
	}

}
