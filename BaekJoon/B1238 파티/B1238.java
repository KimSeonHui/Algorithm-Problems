package M03_3;

import java.io.*;
import java.util.*;

class Vertex implements Comparable<Vertex>{
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

public class B1238 {
	static int N, end;
	static List<Vertex>[] g;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		g = new List[N+1];
		for(int i=1; i<=N; i++) {
			g[i] = new ArrayList<>();
		}
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			g[from].add(new Vertex(to, weight));
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=1; i<=N; i++) {
			int time = 0;
			time += dijkstar(i, end);
			time += dijkstar(end, i);
			
			if(max < time) max = time;
		}
		
		System.out.println(max);
		br.close();
	}

	static int dijkstar(int start , int end) {
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
			if(minVertex == end) break;
			
			for(Vertex vertex : g[minVertex]) {
				if(!v[vertex.to] && dist[vertex.to] > min + vertex.weight) {
					dist[vertex.to] = min + vertex.weight;
					pq.offer(new Vertex(vertex.to, dist[vertex.to]));
				}
			}
		}
		return dist[end];
	}
}