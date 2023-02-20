package M02_4;

import java.io.*;
import java.util.*;

public class B2630 {
	static int white = 0;
	static int green = 0;
	static int[][] spaces;
	
	static void cut(int r, int c, int n) {
		int sum = 0;
		for(int i=r, rEnd=r+n; i<rEnd; i++) {
			for(int j=c, cEnd=c+n; j<cEnd; j++) {
				sum += spaces[i][j];
			}
		}
		
		if(sum == n*n) green++;
		else if(sum == 0) white++;
		else {
			cut(r,c,n/2);
			cut(r,c+n/2,n/2);
			cut(r+n/2,c,n/2);
			cut(r+n/2,c+n/2,n/2);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		spaces = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				spaces[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cut(0,0,n);
		System.out.println(white);
		System.out.println(green);
		br.close();
		
	}
}
