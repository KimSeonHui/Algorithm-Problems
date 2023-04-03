package M04_1;

import java.io.*;

public class B1058 {
	static final int INF = Integer.MAX_VALUE/2;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] g = new int[N][N];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				char ch = str.charAt(j);
				if(i==j) g[i][j]=0;
				else if(ch=='N' && i != j) g[i][j] = INF;
				else g[i][j] = 1;
			}
		}
		
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					g[i][j] = Math.min(g[i][j], g[i][k]+g[k][j]);
				}
			}
		}
		
		int max = 0;
		for(int[] arr : g) {
			int cnt=0;
			for(int val : arr) if(val != 0 && val <=2) cnt++;
			max = Math.max(max, cnt);
		}
		
		System.out.println(max);
		br.close();
	}
}