import java.io.*;
import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        
        
        char[][] type = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}}; // 지표 변호 별 성격 유형 저장 :: 각 지표 별로 알파벳 순서로 저장  
        Map<Character, Integer> score = new HashMap<>(); // 성격 유형 : 설문조사 점수 저장 map
        for(int i=0; i<type.length; i++) {
            char[] t = type[i];
            score.put(t[0], 0);
            score.put(t[1], 0);
        }

        
        // 설문조사 점수 계산
        calScore(score, survey, choices);
        // for(Map.Entry<Character, Integer> pair : score.entrySet()) {
        //     System.out.println(pair.getKey() + " " + pair.getValue());
        // }
        
        
        // 성격유형 계산
        return getResult(score, type);
    }
    
    public void calScore(Map<Character, Integer> score, String[] survey, int[] choices) {
        int[] scores = {0, 3, 2, 1, 0, 1, 2, 3};
        
        for(int i=0; i<survey.length; i++) {
            char notAgree = survey[i].charAt(0);
            char agree = survey[i].charAt(1);
            
            if(choices[i] < 4) score.put(notAgree, score.get(notAgree) + scores[choices[i]]);
            else score.put(agree, score.get(agree) + scores[choices[i]]);
        }
    }
    
    public String getResult(Map<Character, Integer> score, char[][] type) {
        String result = "";
        for(int i=0; i<type.length; i++) {
            char[] t = type[i];
            result += (score.get(t[1]) <= score.get(t[0]) ? t[0] : t[1]); // 걊이 같으면 알파벳 순서가 빠른 t[0]이 저장될 수 있도록
        }
        
        return result;
    }
}