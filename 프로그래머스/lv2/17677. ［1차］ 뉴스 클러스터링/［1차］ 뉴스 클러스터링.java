import java.io.*;
import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        // 1. 전부 대문자로 통일
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        // 2. 2개씩 끊어서 집합 만들기
        List<String> set1 = new ArrayList<>();
        List<String> set2 = new ArrayList<>();
        
        createSet(str1, set1);
        createSet(str2, set2);
        
        // System.out.println(set1);
        // System.out.println(set2);
        
        // 둘 다 공집합일 경우
        if(set1.size() == 0 && set2.size() == 0) return 65536;
        
        // 3. 교집합, 합집합 만들기
        List<String> common = new ArrayList<>();
        List<String> all = new ArrayList<>();

        for(int i=0; i<set1.size(); i++) {
            String ele = set1.get(i);
            if(set2.contains(ele)) {
                common.add(ele);
                set2.remove(ele);
            }
            all.add(ele);
        }
        
        for(int i=0; i<set2.size(); i++) {
            all.add(set2.get(i));
        }
        
        // System.out.println(common);
        // System.out.println(all);
               
        // 4. 자카드 유사도 구하기
        double res = (double)common.size() / (double)all.size();
        int answer = (int)(res *65536);
        return answer;
    }
    
    // 문자열만 있는지 확인
    public boolean isOnlyString(String str) {
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i)<'A' || 'Z'<str.charAt(i)) return false;
        }
        
        return true;
    }
    
    // 집합 만드는 함수
    public void createSet(String str, List<String> set) {
        for(int i=0; i+1<str.length(); i++) {
            String sub = str.substring(i, i+2);
            if(isOnlyString(sub)) { // 공백, 특수문자, 숫자가 없다면
                set.add(sub);
            }
        }
    }
}