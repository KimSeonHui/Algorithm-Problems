import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			int[] start = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			int[] end = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};;
			
			int N = Integer.parseInt(br.readLine());
			int[][] planets = new int[N][3];
			int cnt = 0;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				planets[i][0] = Integer.parseInt(st.nextToken()); // 중점 x
				planets[i][1] = Integer.parseInt(st.nextToken()); // 중점 y
				planets[i][2] = Integer.parseInt(st.nextToken()); // 반지름
				
				double startDis = getDistance(start[0], start[1], planets[i][0], planets[i][1]);
				double endDis = getDistance(end[0], end[1], planets[i][0], planets[i][1]);
				
				// 출발점이 행성 안 && 도착점이 행성 밖 >> 최소 진출 1번
				if(startDis < planets[i][2] && endDis > planets[i][2]) cnt++;
				
				// 출발점이 행성 밖 && 도착점이 행성 안 >> 최소 진입 1번
				if(startDis > planets[i][2] && endDis < planets[i][2]) cnt++;
			}
			
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	static double getDistance(int x, int y, int x2, int y2) {
		return Math.sqrt(Math.pow(x2-x, 2) + Math.pow(y2-y, 2));
	}
}