import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String msg) {
        
        // 1. 초기화
        Map<String, Integer> dic = new LinkedHashMap<>();
        char ch = 'A';
        for(int i=1; i<=26; i++) {
            dic.put(String.valueOf(ch), i);
            ch += 1;
        }
        
        // 2,3,4
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<msg.length(); i++) {
            StringBuilder w = new StringBuilder(String.valueOf(msg.charAt(i)));
            
            // w가 마지막 문자이면 종료
            if(i == msg.length()-1) {
                list.add(dic.get(String.valueOf(msg.charAt(i))));
                break;
            }
            
            String c = String.valueOf(msg.charAt(i+1));
            
            // 사전에 있는 글자이면
            while(dic.containsKey(w+c)) {
                w.append(c); // w = w+c로 변경
                i++;
                
                // 현재 문자가 마지막 문자거나 현재 c가 빈 문자열이면
                if(i == msg.length()-1 || c.equals("")) {
                    c = "";
                    break;
                }
                c = String.valueOf(msg.charAt(i+1)); //c를 w+c 다음 글자로 변경
            }
            
            // w+c가 dic에 없으면 추가
            if(!dic.containsKey(w+c)) dic.put(w+c, dic.size()+1);
            
            // dic에 w가 있으면 list에 추가
            if(dic.get(w.toString()) != null) list.add(dic.get(w.toString()));
            
            if(i == msg.length()-1 && !c.equals("")) {
                list.add(dic.get(String.valueOf(c)));
            }
        }

        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

}