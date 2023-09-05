import java.io.*;
import java.util.*;

class Solution {
    char[] res;
    int N;
    
    List<String> answer;
    
    public String[] solution(String[] orders, int[] course) {
        answer = new ArrayList<>();
        
        // 각 손님이 주문한 단품 메뉴를 모두 코스요리로 구성하기
        for(int i=0; i<course.length; i++) {     
            Map<String, Integer> map = new HashMap<>();
            for(int j=0; j<orders.length; j++) {
                N = course[i];
                res = new char[course[i]];
                comb(0, 0, orders[j], map);
            }
            findMax(map, course[i]);
        }
        
        String[] arr = answer.toArray(new String[0]);
        Arrays.sort(arr);
        return arr;
    }
    
    public void findMax(Map<String, Integer> map, int size) {
        int max = 2;
        
        // 구성한 코스 요리 중 max 값 찾기
        for(Map.Entry<String, Integer> pair : map.entrySet()) {
            if(pair.getKey().length() == size && max < pair.getValue()) {
                max = pair.getValue();
            }
        }
        
        // size가 같고 max값인 것 모두 찾기
        for(Map.Entry<String, Integer> pair : map.entrySet()) {
            if(pair.getKey().length() == size && max == pair.getValue()) {
                answer.add(pair.getKey());
            }
        }
    }
    
    public void comb(int cnt, int start,  String order, Map<String, Integer> map) {
        if(order.length() < N) return; 
        
        if(cnt == N) {
            char[] temp = new char[res.length];
            for(int i=0; i<res.length; i++) {
                temp[i] = res[i];
            }
            String resStr = new String(res);
            
            Arrays.sort(temp);
            String tempStr = new String(temp);
            
            if(!map.containsKey(tempStr)) map.put(tempStr, 1); // 코스에 없으면 생성
            else  map.put(tempStr, map.get(tempStr) + 1); // 코스에 있으면 개수 증가
          
            return;
        }
        
        for(int i=start; i<order.length(); i++) {
            res[cnt] = order.charAt(i);
            comb(cnt+1, i+1, order, map);
        }

    }
}