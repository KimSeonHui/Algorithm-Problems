package backjoon;

import java.io.*;
import java.util.*;

public class B14891 {
	static int[][] gear = new int[4][8];
	static int[] d = new int[4];
	static int gearNum = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int k = 0;
		int rotate = 0;
		int answer = 0;
		
		for(int i=0; i<4; i++) {
			String s = br.readLine();
			for(int j=0; j<8; j++) {
				gear[i][j] = s.charAt(j) - '0';
			}
		}
		k = Integer.parseInt(br.readLine());
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			
			gearNum = Integer.parseInt(st.nextToken());
			rotate = Integer.parseInt(st.nextToken());
			
			d[gearNum-1] = rotate;
			checkRotate(gearNum-1);
			rotateGear();
		}
		
		if(gear[0][0] == 1) answer += 1;
		if(gear[1][0] == 1) answer += 2;
		if(gear[2][0] == 1) answer += 4;
		if(gear[3][0] == 1) answer += 8;
		
		System.out.println(answer);
	}
	
	public static void checkRotate(int gearNum) {
		//좌측 톱니바퀴 회전 확인
		for(int i=gearNum; i>0; i--) {
			if(gear[i][6] != gear[i-1][2]) {
				// 내 회전 방향과 반대로 회전
				d[i-1] = -d[i];
			}
			else break;
		}
		
		//우측 톱니바퀴 회전 확인
		for(int i=gearNum; i<3; i++) {
			if(gear[i][2] != gear[i+1][6]) {
				// 내 회전 방향과 반대로 회전
				d[i+1] = -d[i];
			}
			else break;
		} 
	}
	
	public static void rotateGear() {
		for(int i=0; i<4; i++) {
			//시계 방향 회전
			if(d[i] == 1) {
				int temp = gear[i][7];
				for(int j=7; j>0; j--) {
					gear[i][j] = gear[i][j-1];
				}
				gear[i][0] = temp;		
				d[i] = 0;
			}
			//반시계 방향 회전
			else if(d[i] == -1) {
				int temp = gear[i][0];
				for(int j=0; j<7; j++) {
					gear[i][j] = gear[i][j+1];
				}
				gear[i][7] = temp;
				d[i] = 0;
			}
		}
	}
}
