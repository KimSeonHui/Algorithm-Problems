package backjoon;

import java.io.*;
import java.util.*;

public class B2490 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		for(int i=0; i<3; i++) {
			int sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<4; j++) {
				sum += Integer.parseInt(st.nextToken());
			}
			
			if(sum == 0) sb.append("D").append("\n");
			else if(sum == 1) sb.append("C").append("\n");
			else if(sum == 2) sb.append("B").append("\n");
			else if(sum == 3) sb.append("A").append("\n");
			else if(sum == 4) sb.append("E").append("\n");
		}
		System.out.println(sb.toString());
	}

}
