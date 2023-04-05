package M04_1;

import java.io.*;
import java.util.*;

public class B15961 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 회전 초밥 접시의 수
		int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
		int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
		int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

		// 회전 초밥 입력 받기
		int[] sushi = new int[N];
		for(int i=0; i<N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		
		int start=0, end=k-1;
		int max=0;
		
		int[] v = new int[d+1]; // 현재 먹을 수 있는 초밥 체크
		ArrayDeque<Integer> pick = new ArrayDeque<>(); // 현재 선택한 초밥 
		int cnt = 0; // 현재 먹을 수 있는 서로 다른 초밥의 가짓수
		
		for(int i=start; i<=end; i++) {
			if(v[sushi[i]]==0) cnt++;
			v[sushi[i]]++;
			pick.offer(sushi[i]);
		}
		
		// 현재 선택한 초밥에 쿠폰 초밥이 없으면 가짓수 추가 
		max = Math.max(max, (v[c]==0 ? cnt+1 : cnt)); 
		start++;
		end++;
		
		while(start < N-1) {
			// 선택한 초밥 중 첫번째 초밥 빼기
			int remove = pick.poll();
			v[remove]--;
			if(v[remove]==0) cnt--;
			
			// 다음 초밥을 선택한 초밥에 추가
			if(v[sushi[end]]==0) cnt++;
			v[sushi[end]]++;
			pick.offer(sushi[end]); 
			
			max = Math.max(max, (v[c]==0? cnt+1 : cnt)); // 현재 먹은 초밥에 쿠폰 초밥이 없으면 가짓수 추가 
			start++;
			end++;
			end %=N;
		}
		
		System.out.println(max);
		br.close();
	}
}