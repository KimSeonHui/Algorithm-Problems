package M03_1;

import java.io.*;
import java.util.*;

public class SW2115 {

	static int N, M, C, max, moneyA, moneyB;
	static int[][] map;
	static boolean[][] mapVis;
	static int[] res;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/input_sw2115.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			max = Integer.MIN_VALUE; 
			res = new int[2];
			if(N/2<M) { // 한 줄에 두 일꾼이 겹칠 수 없을 때
				comb(0, 0);
			}
			else duplComb(0,0); // 한 줄에 두 일꾼이 겹칠 수도 있을 때
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
	
	static void comb(int cnt, int start) {
		if(cnt == 2) {
			// 조합이 완성 됐을 때 :: 일꾼들이 채취할 벌꿀 row 위치 선택
			selectPos();
			return;
		}
		
		for(int i=start; i<N; i++) {
			res[cnt] = i;
			comb(cnt+1, i+1);
		}
	}
	
	static void duplComb(int cnt, int start) {
		if(cnt == 2) {
			// 조합이 완성 됐을 때 :: 일꾼들이 채취할 벌꿀 row 위치 선택
			selectPos();
			return;
		}
		
		for(int i=start; i<N; i++) {
			res[cnt] = i;
			comb(cnt+1, i);
		}
	}
	
	static void selectPos() {
		// 두 일꾼이 선택한 가로로 m개 연결된 벌통
		int r1 = res[0]; // 1번 일꾼이 선택한 row
		int r2 = res[1]; // 2번 일꾼이 선택한 row
		for(int a=0; a+M<=N; a++) {
			mapVis = new boolean[N][N];
			next : for(int b=0; b+M<=N; b++) {
				int startA=a, endA = a+M, cnt1=0;
				int startB=b, endB = b+M, cnt2=0;
				int[] a1 = new int[M], b1 = new int[M];
				if(N/2<M) { // 조합
					while(startA < endA) {
						a1[cnt1++]=map[r1][startA];
						startA++;
					}
					while(startB < endB) {
						b1[cnt2++]=map[r2][startB];
						startB++;
					}
				}
				else { // 중복 조합
					while(startA < endA) { 
						a1[cnt1++]=map[r1][startA];
						mapVis[r1][startA] = true;
						startA++;
					}
					while(startB < endB) {
						if(!mapVis[r2][startB]) b1[cnt2++]=map[r2][startB];
						else continue next;
						startB++;
					}
				}
				
				// 두 일꾼이 선택한 가로로 m개 연결된 벌통
				/*System.out.println(Arrays.toString(a1));
				System.out.println(Arrays.toString(b1));*/
				
				moneyA=Integer.MIN_VALUE; moneyB=Integer.MIN_VALUE;
				subsA(0, 0, 0, a1, new boolean[M]);
				subsB(0, 0, 0, b1, new boolean[M]);
				max = Math.max(max, moneyA+moneyB); 
			}
		}
	}
	
	static void subsA(int cnt, int sum, int total, int[] a1, boolean[] v) {
		if(C < sum) return;
		if(cnt==M) {
			moneyA = Math.max(moneyA, total);
			return;
		}
		
		v[cnt] = true;
		subsA(cnt+1, sum+a1[cnt], total+a1[cnt]*a1[cnt], a1, v);
		v[cnt] = false;
		subsA(cnt+1, sum, total, a1, v);
	}
	
	static void subsB(int cnt, int sum, int total, int[] b1, boolean[] v) {
		if(C < sum) return;
		if(cnt==M) {
			moneyB = Math.max(moneyB, total);
			return;
		}
		
		v[cnt] = true;
		subsB(cnt+1, sum+b1[cnt], total+b1[cnt]*b1[cnt], b1, v);
		v[cnt] = false;
		subsB(cnt+1, sum, total, b1, v);
	}
}
