package M02_4;

import java.io.*;
import java.util.*;

public class B17471 {
	static int N, min, all; // all : 그래프 전체 값 저장
	static int[] people; // 각 구역의 인구수 저장
	static boolean[] isUsed; // 부분집합 선택 배열
	static List<Integer>[] g; // 그래프 정보 저장
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		people = new int[N+1];
		for(int i=1; i<=N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
			all += people[i];
		}
		
		g = new List[N+1];
		for(int i=1; i<=N; i++) g[i] = new ArrayList<>();
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int cnt = Integer.parseInt(st.nextToken());
			
			for(int j=0; j<cnt; j++) {
				int to = Integer.parseInt(st.nextToken());
				g[i].add(to);
			}
		}
		isUsed = new boolean[N+1];
		min = Integer.MAX_VALUE;
		subs(1, 0);
		if(min == Integer.MAX_VALUE) min = -1;
		System.out.println(min);
	}
	
	static void subs(int cnt, int peopleSum) {
		if(cnt == N+1) {
			if(peopleSum == 0 || peopleSum == all) return;
			
			// 선거구 인구 차이 구하기 - 최솟값 찾기
			calDistrict(peopleSum);
			return;
		}
		isUsed[cnt] = true;
		subs(cnt+1, peopleSum+people[cnt]);
		isUsed[cnt] = false;
		subs(cnt+1, peopleSum);
	}
	
	static void calDistrict(int sum) {
		int disA = 0;
		int disB = 0;
		
		boolean[] v = new boolean[N+1];
		for(int i=1; i<=N; i++) {
			if(isUsed[i] && !v[i]) {
				//disA = bfs(i, v, isUsed[i]);
				disA = dfs(i, v, isUsed[i], people[i]);
			}
			//else if(!isUsed[i] && !v[i]) disB = bfs(i, v, isUsed[i]);
			else if(!isUsed[i] && !v[i]) disB = dfs(i, v, isUsed[i], people[i]);
		}
		if (sum == disA && all-sum==disB) {
			min = Math.min(min, Math.abs(disA-disB));
		}
	}
	
	static int bfs(int cur, boolean[] v, boolean checked) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		v[cur] = true;
		q.add(cur);
		
		int sum=people[cur];
		while(!q.isEmpty()) {
			cur = q.poll();
			
			for(int val : g[cur]) {
				if(checked == isUsed[val] && !v[val]) {
					sum += people[val];
					v[val] = true; 
					q.offer(val);
				}
			}
		}
		return sum;
	}
	
	static int dfs(int cur, boolean[] v, boolean checked, int sum) {
		v[cur] = true;
		
		for(int val : g[cur]) {
			if(checked == isUsed[val] && !v[val]) {
				sum = dfs(val, v, checked, sum+people[val]);
			}
		}
		return sum;
	}
}
