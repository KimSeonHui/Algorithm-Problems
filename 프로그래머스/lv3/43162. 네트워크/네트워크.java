import java.io.*;
import java.util.*;

class Solution {
    static int[] p;
    public int solution(int n, int[][] computers) {
        int answer = n;
        
        makeSet(n);
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i != j && computers[i][j] == 1) {
                    if(union(i, j)) answer--;
                }
            }
        }
        return answer;
    }
    
    public void makeSet(int n) {
        p = new int[n];
        for(int i=0; i<n; i++) p[i] = i;
    }
    
    public int find(int a) {
        if(p[a] == a) return a;
        return p[a] = find(p[a]);
    }
    
    public boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        
        if(rootA == rootB) return false;
        p[rootB] = rootA;
        return true;
    }
}
