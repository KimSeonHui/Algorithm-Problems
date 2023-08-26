import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        // 의상 종류 별 map 만들기
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<clothes.length; i++) {
            if(map.get(clothes[i][1]) == null) {
                map.put(clothes[i][1], 1);
            }
            else map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
        }
        
        for(Map.Entry<String, Integer> pair : map.entrySet()) {
            answer *= pair.getValue() + 1; // 옷의 종류 수 + 아무것도 안 입을 경우의 수(+1)
        }
        
        return answer-1; // 아무 옷도 안 입을 경우 -1
    }
}