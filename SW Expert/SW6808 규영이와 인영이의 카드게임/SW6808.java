import java.io.*;
import java.util.*;

public class SW6808 {
	static List<Integer> p1;
	static List<Integer> p2;
	static boolean[] v;
	static int[] b;
	static int win=0,lose=0;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
			for(int tc=1; tc<=T; tc++) {
			b = new int[9];
			v = new boolean[9];
			p1 = new ArrayList<>(); // 인영
			p2 = new ArrayList<>(); // 규영
			win=0;
			lose=0;
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int idx1 = 0, idx2 = 0;
			
			for(int i=0; i<9; i++) {
				p1.add(Integer.parseInt(st.nextToken()));
			}
			for(int i=1; i<=18; i++) {
				if(!p1.contains(i)) p2.add(i);
			}
			
			perm(0);
			sb.append("#").append(tc).append(" ").append(win).append(" ").append(lose).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
	
	static void perm(int cnt) {
		if(cnt == 9) {
			// 각 라운드 시작
			playRound();
		}
		
		for(int i=0; i<9; i++) {
			if(v[i]) continue;
			v[i] = true;
			b[cnt] = p2.get(i);
			perm(cnt+1);
			v[i] = false;
		}
	}
	
	static void playRound() {
		int score1 = 0;
		int score2 = 0;
		
		for(int i=0; i<9; i++) {
			int num1 = p1.get(i);
			int num2 = b[i];
			if(num1 > num2) score1 += num1 + num2;
			else if(num1 < num2) score2 += num1 + num2;
		}
		
		if(score1 > score2) win++;
		else if(score1 < score2) lose++;
	}

}
