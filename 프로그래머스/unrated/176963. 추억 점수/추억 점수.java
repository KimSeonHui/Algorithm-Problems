import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        
        // name : yearning으로 hashmap 생성
        Map<String ,Integer> map = new HashMap<>();
        for(int i=0; i<name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<photo.length; i++) {
            int score = 0;
            for(int j=0; j<photo[i].length; j++) {
                if(map.get(photo[i][j]) != null) score += map.get(photo[i][j]);
            }
            list.add(score);
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}