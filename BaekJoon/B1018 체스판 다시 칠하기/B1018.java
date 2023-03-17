package M03_3;

import java.io.*;
import java.util.*;

public class B1018 {

	static char[][] temp, board;
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new char[N][M];
		temp = new char[8][8];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				board[i][j] = str.charAt(j);
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(int r=0; r<=N-8; r++) {
			for(int c=0; c<=M-8; c++) {
				min = Math.min(min, check(r, c, 'W'));
				min = Math.min(min, check(r, c, 'B'));
			}
		}
		System.out.println(min);
		br.close();
	}
	
	static void initBoard(int r, int c) {
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				temp[i][j] = board[i+r][j+c];
			}
		}
	}
	
	static int check(int r, int c, char color) {
		initBoard(r, c);
		
		int cnt = 0;
		if(temp[0][0] != color) {
			cnt++;
			temp[0][0] = color;
		}
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if(j!=0 && temp[i][j-1] == temp[i][j]) {
					cnt++; // 왼쪽 검사
					temp[i][j] = temp[i][j-1]=='W'? 'B' : 'W';
				}
				if(i!=0 && temp[i-1][j] == temp[i][j]) {
					cnt++; // 위쪽 검사
					temp[i][j] = temp[i-1][j]=='W'? 'B' : 'W';
				}
			}
		}
		return cnt;
	}
}