package backjoon;

import java.io.*;
import java.util.*;

public class B7568 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(br.readLine());
		
		LinkedHashMap<Integer, int[]> map = new LinkedHashMap<>();
		
		int num = 0;
		for(int i=0; i <N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map.put(num++ , new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
				
		for(Map.Entry<Integer, int[]> entry : map.entrySet()) {
			int x = entry.getValue()[0];
			int y = entry.getValue()[1];
			 
			int k = 0;
			for(Map.Entry<Integer, int[]> e2 : map.entrySet()) {
				if(x < e2.getValue()[0] && y < e2.getValue()[1]) k++;
			}
			sb.append(k+1).append(" ");
		}
		System.out.println(sb.toString());
	}

}
