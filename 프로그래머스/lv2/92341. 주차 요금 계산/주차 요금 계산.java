import java.io.*;
import java.util.*;

class Solution {   
    public int[] solution(int[] fees, String[] records) {      
       
        Map<String, String> map = new HashMap<>();  // 자동차 별 입차 시간 저장
        Map<String, Integer> timeMap = new HashMap<>(); // 자동차 별 요금 저장
        
        for(int i=0; i<records.length; i++) {
            String[] record = records[i].split(" ");
            timeMap.put(record[1], 0);
        }
        
        // 입차, 출차 기록 저장, 누적 시간 저장
        for(int i=0; i<records.length; i++) {
            String[] record = records[i].split(" ");
            // System.out.println(Arrays.toString(record));
            
            if(map.containsKey(record[1])) { // 입차한 기록이 있을 때
                String[] inTime = map.remove(record[1]).split(":");
                String[] outTime = record[0].split(":");
                
                // 누적 시간 계산
                int hour = Integer.parseInt(outTime[0]) - Integer.parseInt(inTime[0]);
                int min = Integer.parseInt(outTime[1]) - Integer.parseInt(inTime[1]);
                timeMap.put(record[1], timeMap.get(record[1]) + hour * 60 + min);
            }
            else { // 입차 기록 없을 때 
                map.put(record[1], record[0]); 
            }
        }
        
        // 누적 주차 요금 계산
        for(Map.Entry<String, String> pair : map.entrySet()) {
            String[] inTime = pair.getValue().split(":");
            String[] outTime = {"23", "59"};
                
            // 누적 시간 계산
            int hour = Integer.parseInt(outTime[0]) - Integer.parseInt(inTime[0]);
            int min = Integer.parseInt(outTime[1]) - Integer.parseInt(inTime[1]); 
            
            timeMap.put(pair.getKey(), timeMap.get(pair.getKey()) + hour * 60 + min);
        }
        
        List<Map.Entry<String, Integer>> list = new ArrayList(timeMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>> () {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
            
        // System.out.println(Arrays.toString(cars));
        
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = calPay(fees, list.get(i).getValue());
        }
        
        return answer;
    }
    
    public int calPay(int[] fees, int totalTime) {
        if(totalTime <= fees[0]) return fees[1];
        
        else {
            double time = (totalTime - fees[0]);
            double more = Math.ceil(time / fees[2]);
            return fees[1] + (int)more* fees[3];
        }
    }

}