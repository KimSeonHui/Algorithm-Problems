import java.io.*;
import java.util.*;

class Solution {
    int[] input, res;
    int answer=0;
    public int solution(int[] nums) {
        res = new int[3];
        input = nums;
        // System.out.println(Arrays.toString(input));

        comb(0, 0, 0);
        return answer;
    }

    public void comb(int cnt, int start, int sum) {
        if(cnt == 3) {
            // 조합 완성
            // System.out.println("res " + Arrays.toString(res));
            if(isPrime(sum)) answer++; // sum이 소수이면 개수 증가
            return;
        }

        for(int i=start; i<input.length; i++) {
            res[cnt] = input[i];
            sum += input[i];
            comb(cnt+1, i+1, sum);
            sum -= input[i];
        }
    }

    public boolean isPrime(int sum) {
        // System.out.println("sum " + sum);
        for(int i=2; i*i<=sum; i++) {
            for(int j=i*i; j<=sum; j+=i) {
                // System.out.println("i : " + i + " j " + j);
                if(j == sum) return false;
            }
        }
        return true;
    }
}