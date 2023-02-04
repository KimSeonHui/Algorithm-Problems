package backjoon;

import java.io.*;
import java.util.*;

class Point {
	public int r;
	public int c;
	
	public Point(int r, int c) {
		this.r = r;
		this.c = c;
	}

	@Override
	public String toString() {
		return "Point [r=" + r + ", c=" + c + "]";
	}
	
	
}

public class B15686 {
	static int N;
	static int M;
	static List<Point> house;
	static List<Point> chicken;
	static int townChickenDis;
	static boolean[] isOpen;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		townChickenDis = Integer.MAX_VALUE;
		house = new ArrayList<>();
		chicken = new ArrayList<>();
		
		for(int i=0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 1) house.add(new Point(i, j));
				else if(num == 2) chicken.add(new Point(i, j));
			}
		}
		
		isOpen = new boolean[chicken.size()];
		
		backtracking(0,0);
		System.out.println(townChickenDis);
		
	}
	
	public static void backtracking(int start, int cnt) {
		if(cnt == M) {
			// 치킨 거리 계산
			int townTemp = 0;
			
			for(int i=0; i<house.size(); i++) {
				int chickenDis = Integer.MAX_VALUE;
				for(int j=0; j<chicken.size(); j++) {
					if(isOpen[j]) {
						int temp = Math.abs(house.get(i).r - chicken.get(j).r) + Math.abs(house.get(i).c - chicken.get(j).c);
						chickenDis = Math.min(chickenDis, temp);
					}
				}
				townTemp += chickenDis;
			}
			townChickenDis = Math.min(townChickenDis, townTemp);
			return;
		}
		
		for(int i=start; i<chicken.size(); i++) {
			isOpen[i] = true;
			backtracking(i+1, cnt + 1);
			isOpen[i] = false;
		}
	}

}
