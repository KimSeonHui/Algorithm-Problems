import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        // 1. hashmap 만들기
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<people.length; i++) {
             map.put(people[i], limit - people[i]); // 현재 사람 몸무게 : 무게 제한 - 현재 사람 몸무게
        }
        
        // 2. people 배열 오름차순 정렬
        Arrays.sort(people);
        
        // 3. 구명보트 타기
        int answer = 0;
        int small = 0; int large = people.length-1;
        while(small <= large) {
            // people[small]의 값이 현재 사람과 함께 탈 수 있는 몸무게보다 작거나 같으면 >> 현재 사람과 같이 탈 수 있으면
            if(map.get(people[large]) >= people[small]) {
                answer++;
                large--;
                small++;
            }
            else { // people[small]의 값이 현재 사람과 함께 탈 수 있는 몸무게보다 크면 >> 현재 사람과 같이 탈 수 없으면
                answer++;
                large--;
            }
        }
        return answer;
    }
}