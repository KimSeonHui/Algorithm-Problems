import java.io.*;
import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<tangerine.length; i++) {
            if(map.get(tangerine[i]) == null) map.put(tangerine[i], 1);
            else map.put(tangerine[i], map.get(tangerine[i])+1);
        }
        
        List<Integer> valueList = new ArrayList<>(map.values());
        Collections.sort(valueList);
        int cnt = 0;
        int sum = 0;
        for(int i=valueList.size()-1; i>=0; i--) {
            if(valueList.get(i) >= k) return 1;
            
            sum += valueList.get(i);
            cnt++;
            if(sum >= k) break;
        }
        return cnt;
    }
}