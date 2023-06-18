import java.io.*;
import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        
        char[][] type = new char[4][2]; // 지표 변호 별 성격 유형 저장
        type[0] = new char[]{'R', 'T'};
        type[1] = new char[]{'C', 'F'};
        type[2] = new char[]{'J', 'M'};
        type[3] = new char[]{'A', 'N'};
        
        
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
        for(int i=0; i<survey.length; i++) {
            char notAgree = survey[i].charAt(0);
            char agree = survey[i].charAt(1);
            
            int choice = choices[i];
            char getType = notAgree;
            if(choice == 1 || choice == 2 || choice == 3) getType = notAgree;
            else getType = agree;
            
            if(choice == 1 || choice == 7) score.put(getType, score.get(getType) + 3); // 매우
            else if(choice == 2 || choice == 6) score.put(getType, score.get(getType) + 2); 
            else if(choice == 3 || choice == 5) score.put(getType, score.get(getType) + 1); // 약간
        }
    }
    
    public String getResult(Map<Character, Integer> score, char[][] type) {
        String result = "";
        for(int i=0; i<type.length; i++) {
            char[] t = type[i];
            char type1 = t[0];
            char type2 = t[1];
            
            if(score.get(type1) > score.get(type2)) result += type1;
            else if(score.get(type1) < score.get(type2)) result += type2;
            else result += (type1 <= type2 ? type1 : type2);
        }
        
        return result;
    }
}