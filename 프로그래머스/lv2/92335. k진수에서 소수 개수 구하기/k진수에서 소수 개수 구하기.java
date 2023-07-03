import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int k) {
        // 1. n을 k 진수로 변환
        String changedNum = Integer.toString(n, k);

        // 2. 조건에 맞는 소수 찾기
        StringTokenizer st = new StringTokenizer(changedNum, "0");
        int answer = 0;
        while(st.hasMoreTokens()) {
            String token = st.nextToken();
            
            if(isPrime(Long.parseLong(token))) answer++;
        }
        
        return answer;
    }
    
    // 소수 확인
    public boolean isPrime(long num) {
        if(num == 1) return false;
        
        for(int i=2; i<= (long)Math.sqrt(num); i++) {
            if(num %i == 0) return false;
        }
        return true;
    }
}