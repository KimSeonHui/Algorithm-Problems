import java.io.*;
import java.util.*;

class Solution {
    class Vertex {
        int to, weight;
        
        public Vertex(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    
    List<Vertex>[] g;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        g = new List[n+1];
        int[] dist = new int[n+1];
        for(int i=1; i<=n; i++) {
            g[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE / 2;
        }
        for(int i=0; i<edge.length; i++) {
            int from = edge[i][0];
            int to = edge[i][1];
            
            g[from].add(new Vertex(to, 1));
            g[to].add(new Vertex(from, 1));
        }
        
        PriorityQueue<Vertex> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
        pq.offer(new Vertex(1, 0));
        dist[1] = 0;
        
        boolean[] v = new boolean[n+1];
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
        
        //System.out.println(Arrays.toString(dist));
        int max = dist[1];
        for(int i=2; i<=n; i++) {
            if(max < dist[i]) max = dist[i];
        }
        
        for(int i=1; i<=n; i++) {
            if(max == dist[i]) answer++;
        }
        
        return answer;
    }
}