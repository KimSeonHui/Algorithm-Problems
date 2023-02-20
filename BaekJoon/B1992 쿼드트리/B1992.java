package M02_4;

import java.io.*;

public class B1992 {
	static StringBuilder sb;
	static int[][] video;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		video = new int[n][n];
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<n; j++) {
				video[i][j] = str.charAt(j)-'0';
			}
		}
		compress(0,0,n);
		System.out.println(sb.toString());
	}
	
	static void compress(int r, int c, int n) {
		int sum=0;
		for(int i=r; i<r+n; i++) {
			for(int j=c; j<c+n; j++) {
				sum += video[i][j];
			}
		}
		
		if(sum == n*n) sb.append("1");
		else if(sum == 0) sb.append("0");
		else {
			sb.append("(");
			int half = n/2;
			compress(r,c,half);
			compress(r,c+half,half);
			compress(r+half,c,half);
			compress(r+half,c+half,half);
			sb.append(")");
		}
	}
}
