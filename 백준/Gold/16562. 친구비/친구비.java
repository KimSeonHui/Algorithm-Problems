import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] pay, p;
	static HashMap<Integer, Integer> map = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); // 학생 수
		int M = Integer.parseInt(st.nextToken()); // 친구 관계 수
		int K = Integer.parseInt(st.nextToken()); // 가지고 있는 돈
		
		pay = new int[N+1];
		int[] cost = new int[N+1];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=1; i<=N; i++) {
			pay[i] = Integer.parseInt(st.nextToken());
			cost[i] = Integer.MAX_VALUE;
		}
		
		makeSet();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			union(v, w);
		}
		
		for(int i=1; i<=N; i++) {
            // p배열에 저장되어 있는 값은 현재 i번 학생의 상위 부모
            // 최종 루트 일수도 있고 아닐 수도 있음!
            // find함수를 통해 최종 루트를 찾아야 함
			int root = find(i); 
			if(cost[root] >= pay[i]) cost[root] = pay[i];
		}
		
		int ans = 0;
		for(int i=1; i<=N; i++) {
			if(cost[i] != Integer.MAX_VALUE) ans += cost[i];
		}
		
		System.out.println((ans <= K)? ans : "Oh no");
		br.close();
	}
	
	static void makeSet() {
		p = new int[N+1];
		for(int i=1; i<=N; i++) p[i] = i;
	}
	
	static int find(int a) {
		if(p[a] == a) return a;
		return p[a] = find(p[a]);
	}
	
	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		int minRoot = 0;
        // a, b 중 더 작은 root를 부모로 저장
		if(aRoot != bRoot) {
			if(aRoot <= bRoot) {
				p[bRoot] = aRoot;
				minRoot = aRoot;
			}
			else {
				p[aRoot] = bRoot;
				minRoot = bRoot;
			}
		}
	}
}