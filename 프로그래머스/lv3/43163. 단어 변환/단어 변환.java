import java.io.*;
import java.util.*;

class Solution {
    class Word {
        String word;
        int depth;
        
        public Word(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }
    }
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        // target이 words안에 있는지 확인
        boolean isTarget = false;
        for(int i=0; i<words.length; i++) {
            if(words[i].equals(target)) isTarget = true;
        }
        if(!isTarget) return 0;
        
        
        // target이 words 안에 있다면 bfs
        return bfs(begin, target, words);
    }
    
    public int bfs(String begin, String target, String[] words) {
        ArrayDeque<Word> q = new ArrayDeque<>();
        q.offer(new Word(begin, 0));
        
        while(!q.isEmpty()) {
            Word cur = q.poll();
            
            if(cur.word.equals(target)) return cur.depth;
            
            for(int i=0; i<words.length; i++) {
                String str = words[i];
                int cnt = 0;
                
                for(int j=0; j<begin.length(); j++) {
                    if(cur.word.charAt(j) == str.charAt(j)) cnt++;
                }
                
                if(begin.length() - cnt == 1) {
                    q.offer(new Word(str, cur.depth+1));
                }
            }
        }
        return 0;
    }
}