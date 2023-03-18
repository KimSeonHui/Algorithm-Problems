package M03_3;

import java.io.*;
import java.util.*;

public class B18352 {
	
	static class Vertex implements Comparable<Vertex>{
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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		List<Vertex>[] g = new List[N+1];
		int[] dist = new int[N+1];
		for(int i=1; i<=N; i++) {
			g[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			g[from].add(new Vertex(to, 1));
		}
		
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
			//if(minVertex == N) break;
			
			for(Vertex vertex : g[minVertex]) {
				if(!v[vertex.to] && dist[vertex.to] > min + vertex.weight) {
					dist[vertex.to] = min + vertex.weight;
					pq.offer(new Vertex(vertex.to, dist[vertex.to]));
				}
			}
		}
		
		int cnt=0;
		for(int i=1; i<=N; i++) {
			if(dist[i] == K) {
				sb.append(i).append("\n");
				cnt++;
			}
		}
		
		if(cnt==0) sb.append(-1);
		System.out.println(sb.toString());
		br.close();
	}
}
