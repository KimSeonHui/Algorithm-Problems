import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        for(int i=0; i<discount.length-9; i++) {
            int total = 10; // 사려고 하는 전체 수
            boolean flag = true; // 연속으로 구매가능한지
            
            Map<String, Integer> map = initMap(want, number);
            for(int j=i; j<i+10; j++) {
                if(map.get(discount[j]) != null && map.get(discount[j]) != 0) {
                    map.put(discount[j], map.get(discount[j])-1);
                    total--;
                }
                else {
                    flag = false;
                    break;
                }
            }
            
            if(flag && total == 0) answer++;
        }
        return answer;
    }
    
    public Map<String, Integer> initMap(String[] want, int[] number) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<want.length; i++) {
            map.put(want[i], number[i]);
        }
        return map;
    }
}