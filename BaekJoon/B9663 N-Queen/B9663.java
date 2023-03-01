package M03_1;

import java.io.*;

public class B9663 {
	static int N, cnt;
	static int[] b;
	static boolean[] col, rightup, leftdown;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		b = new int[N];
		col = new boolean[N];
		rightup = new boolean[N+N];
		leftdown = new boolean[N+N];
		
		cnt=0;
		setQueen(0);
		System.out.println(cnt);
		br.close();
	}
	
	static void setQueen(int rowNum) {
		if(rowNum==N) {
			cnt++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(isAble(rowNum, i)) {
				col[i]= true;
				rightup[rowNum+i] = true;
				leftdown[N-1-(rowNum-i)] = true;
				setQueen(rowNum+1);
				col[i]= false;
				rightup[rowNum+i] = false;
				leftdown[N-1-(rowNum-i)] = false;
			}
		}
	}

	static boolean isAble(int rowNum, int colNum) {
		if(col[colNum]) return false;
		if(rightup[rowNum+colNum] || leftdown[N-1-(rowNum-colNum)]) return false;
		return true;
	}
}
