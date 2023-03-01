package M03_1;

import java.io.*;
import java.util.*;

public class SW4013 {

	static int[][] mag;
	static int[] d;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/input_sw4013.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int K = Integer.parseInt(br.readLine());
			mag = new int[4][8];
			d = new int[4];
			
			for(int i=0; i<4; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<8; j++) {
					mag[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			while(K>0) {
				st = new StringTokenizer(br.readLine(), " ");
				int num = Integer.parseInt(st.nextToken())-1;
				int dir = Integer.parseInt(st.nextToken());
				
				d[num] = dir;
				rotate(num, dir);
				K--;
			}
			
			int ans = 0;
			if(mag[0][0]==1) ans+=1;
			if(mag[1][0]==1) ans+=2;
			if(mag[2][0]==1) ans+=4;
			if(mag[3][0]==1) ans+=8;
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
	
	static void rotate(int num, int dir) {
		checkRotateDir(num);
		
		for(int i=0; i<4; i++) {
			if(d[i]==1) { // 시계 방향 회전
				int temp = mag[i][7];
				for(int j=7; j>0; j--) {
					mag[i][j] = mag[i][j-1];
				}
				mag[i][0] = temp;
			}
			else if(d[i]==-1) { // 반시계 방향 회전
				int temp = mag[i][0];
				for(int j=0; j<7; j++) {
					mag[i][j] = mag[i][j+1];
				}
				mag[i][7] = temp;
			}
			d[i] = 0;
		}
	}
	
	static void checkRotateDir(int num) {
		// 우측 자석 확인
		for(int i=num; i<3; i++) {
			if(mag[i][2]!=mag[i+1][6]) d[i+1] = -d[i]; // 붙어 있는 부분이 서로 다르면
		}
		
		// 좌측 자석 확인
		for(int i=num; i>0; i--) {
			if(mag[i][6]!=mag[i-1][2]) d[i-1] = -d[i]; // 붙어 있는 부분이 서로 다르면
		}
	}
}
