package M04_1;

import java.io.*;
import java.util.*;

public class B9205 {
	static String answer;
	static List<int[]> targets;
	static boolean[] v;
	static int endX, endY;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			targets = new ArrayList<>();
			
			// 상근이네 집 좌표 
			StringTokenizer st = new StringTokenizer(br.readLine(), " "); 
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			targets.add(new int[] {startX,startY});
			
			// 편의점 좌표
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " "); 
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				targets.add(new int[] {x,y});
			}
			
			// 페스티벌 좌표
			st = new StringTokenizer(br.readLine(), " "); 
			endX = Integer.parseInt(st.nextToken());
			endY = Integer.parseInt(st.nextToken());
			targets.add(new int[] {endX, endY});
			
			v = new boolean[102];
			answer = "";
			bfs(startX, startY);
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	static void bfs(int startX, int startY) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		v[0] = true;
		q.offer(new int[] {startX, startY});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			if(cur[0]==endX && cur[1]==endY) {
				answer = "happy";
				return;
			}
			
			for(int i=0; i<targets.size(); i++) {
				int dx = Math.abs(targets.get(i)[0]-cur[0]);
				int dy = Math.abs(targets.get(i)[1]-cur[1]);
				
				if(dx+dy<=1000 && !v[i]) {
					v[i] = true;
					q.offer(new int[] {targets.get(i)[0], targets.get(i)[1]});
				}
			}
		}
		answer = "sad";
	}
}