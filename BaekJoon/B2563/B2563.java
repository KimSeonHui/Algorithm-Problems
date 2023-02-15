package backjoon;

import java.io.*;
import java.util.*;

public class B2563 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[][] paper = new boolean[100][100];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int r=y; r<y+10; r++) {
				for(int c=x; c<x+10; c++) {
					paper[r][c] = true;
				}
			}
		}
		
		int cnt = 0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(paper[i][j]) cnt++;
			}
		}
		System.out.println(cnt);
	}
}
