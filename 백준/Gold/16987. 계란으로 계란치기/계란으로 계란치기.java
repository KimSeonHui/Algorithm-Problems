import java.io.*;
import java.util.*;

public class Main {
	static int N, max;
	static int[][] eggs;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		eggs = new int[N][2];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			eggs[i][0] = Integer.parseInt(st.nextToken()); // 내구도
			eggs[i][1] = Integer.parseInt(st.nextToken()); // 무게
		}
		
		hit(0, 0);
		System.out.println(max);
		br.close();
	}
	
	static void hit(int index, int cnt) { // index : 현재 들고 있는 계란의 index, cnt : 지금까지 깬 계란의 수
		if(index==N) {
			max = Math.max(max, cnt);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(index==i) continue; // 들고 있는 계란과 칠 계란이 같으면 통과
			if(eggs[index][0]<=0 || eggs[i][0]<=0) { // 들고 있는 계란이 깨졌거나 칠 계란이 이미 깨졌으면
				hit(index+1, cnt); // 치지 않고 넘어가기
			}
			else { // 계란 깨기
				eggs[index][0] -= eggs[i][1];
				eggs[i][0] -= eggs[index][1];
				
				int breakEggs = 0; // 깨진 계란 카운트
				if(eggs[index][0]<=0) breakEggs++;
				if(eggs[i][0]<=0) breakEggs++;
				
				hit(index+1, cnt+breakEggs);
				
				eggs[index][0] += eggs[i][1];
				eggs[i][0] += eggs[index][1];
			}
		}
	}
}