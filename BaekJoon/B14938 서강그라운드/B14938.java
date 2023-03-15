package M03_3;

import java.io.*;
import java.util.*;

public class B14938 {
	
	static class Vertex implements Comparable<Vertex> {
		int to, weight;
		
		public Vertex(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(weight, o.weight);
		}
	}
	
	static int N, range;
	static int[] items;
	static List<Vertex>[] g;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		range = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		items = new int[N+1];
		g = new List[N+1];
		
		for(int i=1; i<=N; i++) {
			items[i] = Integer.parseInt(st.nextToken());
			g[i] = new ArrayList<>();
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			g[from].add(new Vertex(to, weight));
			g[to].add(new Vertex(from, weight));
		}
		
		int max = 0;
		for(int i=1; i<=N; i++) {
			int total = dijkstra(i);
			
			if(max < total) max = total;
		}
		System.out.println(max);
		br.close();
	}
	
	static int dijkstra(int start) {
		int[] dist = new int[N+1];
		for(int i=1; i<=N; i++) dist[i] = Integer.MAX_VALUE;
		
		boolean[] v = new boolean[N+1];
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.offer(new Vertex(start, 0));
		
		while(!pq.isEmpty()) {
			Vertex cur = pq.poll();
			int minVertex = cur.to;
			int min = cur.weight;
			
			if(v[minVertex]) continue;
			v[minVertex] = true;
			
			for(Vertex vertex : g[minVertex]) {
				if(!v[vertex.to] && dist[vertex.to] > min + vertex.weight) {
					dist[vertex.to] = min + vertex.weight;
					pq.offer(new Vertex(vertex.to, dist[vertex.to]));
				}
			}
		}
		
		int total = 0;
		for(int i=1; i<=N; i++) {
			if(dist[i] <= range) {
				total += items[i];
			}
		}
		return total;
	}
}