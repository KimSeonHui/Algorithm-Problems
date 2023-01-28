package backjoon;

import java.io.*;
import java.util.*;

public class B14889 {
	static int N = 0;
	static boolean[] isTeam;
	static int[][] power;
	static int min = 100;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		power = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				power[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		isTeam = new boolean[N];
		comb(0,0);
		
		System.out.println(min);
	}
	
	public static void comb(int cnt, int start) {
		if(cnt == N/2) {
			//각 팀의 능력치 계산하기
			System.out.println(Arrays.toString(isTeam));
			min = calTeamPower();
			return;
		}
		
		for(int i=start; i<N; i++) {
			if(!isTeam[i]) {
				isTeam[i] = true;
				comb(cnt+1, i+1);
				isTeam[i] = false;
			}
		}
	}
	
	public static int calTeamPower() {
		int teamStart = 0;
		int teamLink = 0;
		
		for(int i=0; i < N; i++) {
			for(int j=i+1; j<N; j++) {
				if(isTeam[i] && isTeam[j]) teamStart += power[i][j] + power[j][i];
				if(!isTeam[i] && !isTeam[j]) teamLink += power[i][j] + power[j][i];
			}
		}
		
		int cal = Math.abs(teamStart - teamLink);
		return Math.min(min, cal);
	}
	
}
