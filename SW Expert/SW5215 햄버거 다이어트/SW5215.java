import java.io.*;
import java.util.*;

public class SW5215 {
	static int N, L, max;
	static int[][] data;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			data = new int[N][2]; // 맛 점수 , 칼로리
			max = 0;
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				data[i][0] = Integer.parseInt(st.nextToken());
				data[i][1] = Integer.parseInt(st.nextToken());
			}
			
			subs(0,0,0);
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
	
	static void subs(int cnt, int cal, int fSum) {
		if(cal > L) return;
		if(cnt == N) {
			// 맛 점수 계산
			max = Math.max(max, fSum);
			return;
		}

		subs(cnt+1, cal+data[cnt][1], fSum + data[cnt][0]); // 재료 선택 했을 때
		subs(cnt+1, cal, fSum); // 재료 선택 안 했을 때
	}
}
