import java.io.*;
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        
        // 1. 참가자 데이터 map에 넣기
        for(int i=0; i<participant.length; i++) {
            if(map.get(participant[i]) == null) map.put(participant[i], 1);
            else map.put(participant[i], map.get(participant[i]) + 1);
        }
        
        // 2. 완주자 순회하며 map에서 제거하기
        for(int i=0; i<completion.length; i++) {
            map.put(completion[i], map.get(completion[i]) - 1);
            if(map.get(completion[i]) == 0) map.remove(completion[i]);
        }
        
        return (String)map.keySet().toArray()[0];
    }
}