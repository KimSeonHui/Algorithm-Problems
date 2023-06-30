import java.io.*;
import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int time = 0;
        
        ArrayDeque<String> cache = new ArrayDeque<>();
        for(int i=0; i<cities.length; i++) {
            String city = cities[i].toLowerCase();
            if(cache.contains(city)) { // cache hit
                cache.remove(city);
                cache.offer(city);
                time += 1;
            }
            else { // cache miss
                if(cache.size() >= cacheSize) {
                    cache.poll(); // cache가 비어있으면 null을 리턴 
                }
                if(cacheSize > 0) cache.offer(city);
                time += 5;
            }
        }
        return time;
    }
}