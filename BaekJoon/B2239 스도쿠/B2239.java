package M03_5;

import java.io.*;
import java.util.*;

public class B2239 {
	static int[][] board;
	static List<int[]> list;
	static boolean end;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new int[9][9];
		 list = new ArrayList<>();
		
		for(int i=0; i<9; i++) {
			String str = br.readLine();
			for(int j=0; j<9; j++) {
				board[i][j] = str.charAt(j)-'0';
				if(board[i][j]==0) list.add(new int[] {i, j});
			}
		}
		
		end = false;
		setNum(0);
		br.close();
	}
	
	static void setNum(int index) {
		if(end) return; 
		
		if(index==list.size()) {
			StringBuilder sb = new StringBuilder();
			for(int[] b : board) {
				for(int val : b) sb.append(val);
				sb.append("\n");
			}
			System.out.println(sb);
			end = true;
			return;
		}
		
		for(int i=1; i<=9; i++) {
			int[] pos = list.get(index);
			int r = pos[0]; int c = pos[1];
			if(isAble(r,c,i)) {
				board[r][c] = i;
				setNum(index+1);
				board[r][c] = 0;
			}
		}
	}
	
	static boolean isAble(int r, int c, int num) {
		//행, 열 확인
		for(int i=0; i<9; i++) {
			if(board[i][c] == num || board[r][i] == num) return false;
		}
		
		//3x3 박스 확인
		if(!checkBox(r,c,num)) return false;
		return true;
	}
	
	static boolean checkBox(int r, int c, int num) {
		int startR, startC, endR, endC;
		if(r/3==0) {
			startR=0;
			endR=2;
		}
		else if(r/3==1) {
			startR=3;
			endR=5;
		}
		else {
			startR=6;
			endR=8;
		}
		
		if(c/3==0) {
			startC=0;
			endC=2;
		}
		else if(c/3==1) {
			startC=3;
			endC=5;
		}
		else {
			startC=6;
			endC=8;
		}
		
		for(int i=startR; i<=endR; i++) {
			for(int j=startC; j<=endC; j++) {
				if(board[i][j] == num) return false;
			}
		}
		return true;
	}
}