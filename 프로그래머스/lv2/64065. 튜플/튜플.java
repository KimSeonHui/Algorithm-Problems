import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        // 1. s의 제일 바깥 괄호 제거
        s = s.substring(1, s.length()-1);
        
        // 2. },으로 s split
        String[] items = s.split("},");
        
        // 3. split된 원소들을 원소 길이로 오름차순 정렬
        Arrays.sort(items, (o1, o2) -> Integer.compare(o1.length(), o2.length()));
        
        // 4. set에 넣어 중복 제거
        Set<Integer> set = new LinkedHashSet<>(); // 정렬된 순서대로 저장해야하기 때문에 LinkedHashSet 사용
        for(int i=0; i<items.length; i++) {
            items[i] = items[i].replace("{", "").replace("}", ""); // 불필요한 문자열 제거
            
            String[] split = items[i].split(","); // ,으로 split해 숫자만 남김
            for(int j=0; j<split.length; j++) set.add(Integer.parseInt(split[j])); // 숫자만 set에 저장
        }
        
        // System.out.println(Arrays.toString(items));
        
        
        // 5. set을 배열에 옮기기
        int[] answer = new int[set.size()];
        Iterator<Integer> iter = set.iterator();
        int index = 0;
        while(iter.hasNext()) {
            answer[index++] = iter.next();
        }
        
        return answer;
    }
}