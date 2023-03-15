package M03_3;

import java.io.*;
import java.util.*;

public class B10282 {
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
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int N = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			List<Vertex>[] g = new List[N+1];
			int[] dist = new int[N+1];
			for(int i=1; i<=N; i++) {
				g[i] = new ArrayList<>();
				dist[i] = Integer.MAX_VALUE;
			}
			
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				g[to].add(new Vertex(from, weight));
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
				v[minVertex]  =true;
				
				for(Vertex vertex : g[minVertex]) {
					if(!v[vertex.to] && dist[vertex.to] > min + vertex.weight) {
						dist[vertex.to] = min + vertex.weight;
						pq.offer(new Vertex(vertex.to, dist[vertex.to]));
					}
				}
			}
			
			int cnt=0, time=0;
			for(int i=1; i<=N; i++) {
				if(dist[i] != Integer.MAX_VALUE) {
					cnt++;
					if(time < dist[i]) time = dist[i];
				}
			}
			sb.append(cnt).append(" ").append(time).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
}