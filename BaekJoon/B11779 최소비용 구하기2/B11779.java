package M03_3;

import java.io.*;
import java.util.*;

public class B11779 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[][] g = new int[N+1][N+1]; // 인접 행렬 생성
		int[] dist = new int[N+1]; 
		for(int i=0; i<N+1; i++) {
			for(int j=0; j<N+1; j++) {
				g[i][j] = Integer.MAX_VALUE; // 가중치가 0일 수도 있기 때문에 최댓값을 초기화
			}
			dist[i] = Integer.MAX_VALUE; // dist 배열 초기화
		}
		
		// 그래프 입력 받기
		StringTokenizer st;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			if(g[from][to] > weight) g[from][to] = weight;
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		
		boolean[] v = new boolean[N+1];
		int[] parent = new int[N+1]; // 해당 정점의 부모 저장
		List<Integer> city = new ArrayList<>(); 
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
		pq.offer(new int[] {start, 0});
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int to = (int) cur[0];
			int min = cur[1];
			
			if(v[to]) continue;
			v[to] = true;
			//city.add(to);
			if(to == end) break;
			
			for(int j=1; j<=N; j++) {
				if(!v[j] && g[to][j]!=Integer.MAX_VALUE && dist[j] > min + g[to][j]) {
					dist[j] = min + g[to][j];
					pq.offer(new int[] {j, dist[j]});
					
					parent[j] = to; // j번째 정점으로 오는 부모 to 저장
				}
			}
		}
		
		int now = end;
		while(parent[now] != 0) {
			city.add(now);
			now = parent[now];
		}
		city.add(start);
		
		sb.append(dist[end]).append("\n").append(city.size()).append("\n");
		for(int i=city.size()-1; i>=0; i--) {
			sb.append(city.get(i)).append(" ");
		}
		
		System.out.println(sb.toString());
		br.close();
	}
}