package M03_1;

import java.io.*;
import java.util.*;

public class B11403 {
	static int N;
	static int[][] g;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine()); 
		g = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				g[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(g[i][k]==1 && g[k][j]==1) g[i][j]=1;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(g[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
}
