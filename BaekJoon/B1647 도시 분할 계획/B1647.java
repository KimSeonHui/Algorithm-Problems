package M03_2;

import java.io.*;
import java.util.*;

public class B1647 {
	static class Vertex implements Comparable<Vertex>{
		int no, weight;
		
		public Vertex(int no, int weight) {
			this.no = no;
			this.weight = weight;
		}
	
		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(weight, o.weight);
		}
	}

	static int N, E, min;
	static boolean[] v;
	static List<Vertex>[] g;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		g = new List[N+1];
		for(int i=1; i<=N; i++) g[i] = new ArrayList<>();
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			g[from].add(new Vertex(to, weight));
			g[to].add(new Vertex(from, weight));
		}
		
		min = Integer.MAX_VALUE;
		v = new boolean[N+1];
		subs(1, 0);
		System.out.println(min);
		br.close();
	}
	
	static void subs(int cnt, int town) {
		if(cnt == N+1) {
			// 부분집합 완성
			if(town == 0 || town == N) return;
			
			calMin(town);
			return;
		}
		
		v[cnt] = true;
		subs(cnt+1, town+1);
		v[cnt] = false;
		subs(cnt+1, town);
	}
	
	static void calMin(int townACnt) {
		int[] townA = new int []{Integer.MAX_VALUE, 0};
		int[] townB = new int []{Integer.MAX_VALUE, 0};
		
		for(int i=1; i<=N; i++) {
			if(v[i]) {
				townA = getMinCost(i, v[i], townACnt);
				break;
			}
		}
		for(int i=1; i<=N; i++) {
			if(!v[i]) {
				townB = getMinCost(i, v[i], N-townACnt);
				break;
			}
		}
		
		if(townA[1]==townACnt && townB[1]==N-townACnt) {
			min = Math.min(min, townA[0]+townB[0]);
		}
	}
	
	static int[] getMinCost(int num, boolean isTownA, int all) {
		int cost = 0;
		
		boolean[] vertexVis = new boolean[N+1];
		int[] minEdge = new int[N+1];
		for(int i=1; i<=N; i++) minEdge[i] = Integer.MAX_VALUE;
		minEdge[num] = 0;
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.offer(new Vertex(num, 0));
		
		int cnt=0;
		while(!pq.isEmpty()) {
			Vertex cur = pq.poll();
			
			int minVertex = cur.no;
			int min = cur.weight;
			
			if(vertexVis[minVertex]) continue;
			vertexVis[minVertex] = true;
			cost += min;
			
			for(Vertex vertex : g[minVertex]) {
				if(!vertexVis[vertex.no] && v[vertex.no]==isTownA && minEdge[vertex.no] > vertex.weight) {
					minEdge[vertex.no] = vertex.weight;
					pq.offer(vertex);
				}
			}
			
			if(++cnt == all) break;
		}
		return new int[] {cost, cnt};
	}
}
