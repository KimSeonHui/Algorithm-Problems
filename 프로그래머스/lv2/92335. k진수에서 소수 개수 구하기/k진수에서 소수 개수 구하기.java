import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int k) {
        // 1. n을 k 진수로 변환
        String changedNum = changeNum(n, k);
        // System.out.println(changedNum);

        // 2. 조건에 맞는 소수 찾기
        StringTokenizer st = new StringTokenizer(changedNum, "0");
        int answer = 0;
        while(st.hasMoreTokens()) {
            String token = st.nextToken();
            // System.out.println(token);
            
            if(isPrime(Long.parseLong(token))) answer++;
        }
        
        return answer;
    }
    
    public String changeNum(int n, int k) {
        if(k == 10) return Integer.toString(n);
        
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            sb.insert(0, n % k);
            n = n / k;
        }

        return sb.toString();
    }
    
    public boolean isPrime(long num) {
        if(num == 1) return false;
        
        long a = (long)Math.sqrt(num) + 1;
        for(int i=2; i<a; i++) {
            if(num %i == 0) return false;
        }
        return true;
    }
}