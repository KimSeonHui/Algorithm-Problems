import java.io.*;
import java.util.*;

class Solution {
    int N, total, min;
    int[][] g;
    int[] p;
    
    public int solution(int n, int[][] wires) {
        N = n;
        min = Integer.MAX_VALUE;
        
        for(int i=0; i<wires.length; i++) {
            total = n;
            makeSet();
            
            for(int j=0; j<wires.length; j++) {
                if(i != j) {
                    int from = wires[j][0];
                    int to = wires[j][1];
                    
                    union(from, to);
                }
            }       
            
            findMin();
        }
        return min;
    }
    
    public void findMin() {
        for(int i=1; i<=N; i++) find(i);
        
        int num1= p[1]; int cnt1 = 1; int cnt2 = 0;
        for(int i=2; i<=N; i++) {
            if(num1 == p[i]) cnt1++;
            else cnt2++;
        }
            
        min = Math.min(min, Math.abs(cnt1 - cnt2));
    }
    
    public void makeSet() {
        p = new int[N+1];
        for(int i=1; i<=N; i++) p[i] = i;
    }
    
    public int find(int a) {
        if(p[a] == a) return a;
        return p[a] = find(p[a]);
    }
    
    public void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        
        if(aRoot < bRoot) p[bRoot] = aRoot;
        else if(aRoot > bRoot) p[aRoot] = bRoot;
    }
}