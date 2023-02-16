import java.io.*;
import java.util.*;

public class SW4012 {
	static int[][] data;
	static int N ,R;
	static boolean[] v;
	static int min;
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			R = N/2;
			data = new int[N][N];
			v = new boolean [N];
			min = Integer.MAX_VALUE;
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					data[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			comb(0,0);
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
	
	static void comb(int cnt, int start) {
		if(cnt == R) {
			// 맛  최솟값 계산하기
			min = cal_flavor();
		}
		for(int i=start; i<N; i++) {
			v[i] = true;
			comb(cnt+1, i+1);
			v[i] = false;
		}
	}
	
	static int cal_flavor() {
		int aSum = 0;
		int bSum = 0;
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				if(v[i] && v[j]) {
					 aSum += data[i][j] + data[j][i];
					 continue;
				}
				else if(!v[i] && !v[j]) {
					bSum += data[i][j] + data[j][i];
					continue;
				}
			}
		}
		int minFlavor = Math.min(min, Math.abs(aSum-bSum));
		return minFlavor;
	}
}
