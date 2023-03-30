package M03_5;

import java.io.*;
import java.util.*;

class Vertex implements Comparable<Vertex>{
	int to;
	double weight;
	
	public Vertex(int to, double weight) {
		this.to = to;
		this.weight = weight;
	}

	@Override
	public int compareTo(Vertex o) {
		return Double.compare(weight, o.weight);
	}
}

public class SW1251 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] xs = new int[N];
			int[] ys = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++) {
				xs[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++) {
				ys[i] = Integer.parseInt(st.nextToken());
			}
			
			double[][] g = new double[N][N];
			double[] minEdge = new double[N];
			for(int i=0; i<N; i++) {
				for(int j=i+1; j<N; j++) {
					g[i][j] = Math.sqrt(Math.pow(Math.abs(xs[i]-xs[j]), 2) + Math.pow(Math.abs(ys[i]-ys[j]), 2));
//					g[i][j] = Math.abs(xs[i]-xs[j]) + Math.abs(ys[i]-ys[j]);
					g[j][i] = g[i][j];
				}
				minEdge[i] = Integer.MAX_VALUE;
			}
			
			double E = Double.parseDouble(br.readLine());
			boolean[] v = new boolean[N];
			PriorityQueue<Vertex> pq = new PriorityQueue<>();
			pq.offer(new Vertex(0, 0));
			minEdge[0] = 0;
			
			int cnt=0;
			double res=0;
			while(!pq.isEmpty()) {
				Vertex cur = pq.poll();
				int minVertex = cur.to;
				double min = cur.weight;
				
				if(v[minVertex]) continue;
				v[minVertex] = true;
				res += (min*min)*E;
				if(cnt++ == N-1) break;
				
				for(int j=0; j<N; j++) {
					if(!v[j] && g[minVertex][j] != 0 && minEdge[j] > g[minVertex][j]) {
						minEdge[j] = g[minVertex][j];
						pq.offer(new Vertex(j, minEdge[j]));
					}
				}
			}
			sb.append("#").append(t).append(" ").append(String.format("%.0f", res)).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}