package backjoon;

import java.io.*;
import java.util.*;

class Curve {
	ArrayList<int[]> points = new ArrayList<>();
	int[] endpoint;
	
	Curve() {};
	
	Curve(int[] point, int[] end) {
		points.add(point);
		endpoint = end;
	}
	
	Curve(int[] point) {
		points.add(point);
	}

	@Override
	public String toString() {
		String s = "";
		for(int[] a : points) s += Arrays.toString(a) + " ";
		return s + Arrays.toString(endpoint);
	}
}

public class B15685 {
	static int[] dy = {0,-1,0,1}; // 우상좌하
	static int[] dx = {1,0,-1,0}; // 우상좌하
	static int[][] data;
	static boolean[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		data = new int[N][4];
		map = new boolean[101][101];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			data[i][0] = Integer.parseInt(st.nextToken()); // 시작 x 좌표
			data[i][1] = Integer.parseInt(st.nextToken()); // 시작 y 좌표
			data[i][2] = Integer.parseInt(st.nextToken()); // 시작 방향
			data[i][3] = Integer.parseInt(st.nextToken()); // 세대
		}
		
		// 드래곤 커브 그리기
		for(int i=0; i<N; i++) {
			drawCurve(i, 0, data[i][3], new Curve[data[i][3]+1]);
		}
		
		// 정사각형 네 꼭짓점이 드래곤 커브인 것 구하기
		int cnt =0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]) cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	// index : data에서 몇 번째 정보인지 , cnt : 현재 몇 세대 커브인지, gen : 최종 세대 값, curves : 각 세대 커브 좌표
	static void drawCurve(int index, int cnt, int gen, Curve[] curves) {
		if(cnt == gen+1) {
			// 드래곤 커브 완성 후 긋기
			for(int i=0; i<curves[cnt-1].points.size(); i++) {
				int[] pos = curves[cnt-1].points.get(i);
				if(!map[pos[0]][pos[1]]) map[pos[0]][pos[1]] = true;
			}
			int[] end = curves[cnt-1].endpoint;
			map[end[0]][end[1]] = true;
			return;
		}
		
		if(cnt == 0) { // 0세대 만들기
			int d = data[index][2];
			int[] start = {data[index][0], data[index][1]};
			int[] end = {data[index][0] + dx[d], data[index][1] + dy[d]};
			curves[cnt] = new Curve(start, end);
			drawCurve(index, cnt+1, gen, curves);
		}
		else {
			curves[cnt] = new Curve();
			
			//이전 세대 점들을 현재 세대 점들로
			for(int i=0; i<curves[cnt-1].points.size(); i++) {
				int[] start = curves[cnt-1].points.get(i);
				curves[cnt].points.add(start);
			}
			curves[cnt].points.add(curves[cnt-1].endpoint); // 이전 세대 끝점도 현제 세대 점으로 추가
			
			// 이전 세대 점들(끝점 제외) 회전 시켜서  추가하기 - 시작점은 끝점으로 추가
			for(int i=0; i<curves[cnt-1].points.size(); i++) {
				int[] start = curves[cnt-1].points.get(i);
				int rotateX =  -1*(start[1] - curves[cnt-1].endpoint[1]) + curves[cnt-1].endpoint[0];
				int rotateY = start[0] - curves[cnt-1].endpoint[0] + curves[cnt-1].endpoint[1];
				if(i == 0) { // 시작점이면 끝점으로 추가하기
					curves[cnt].endpoint = new int[]{rotateX, rotateY};
				}
				else {
					curves[cnt].points.add(new int[]{rotateX, rotateY});
				}
			}
			
			//다음 세대 커브 진행
			drawCurve(index, cnt+1, gen, curves);
		}
	}
}
